package info.csoe.service.impl;

import info.csoe.bean.Rights;
import info.csoe.dao.RightsDao;
import info.csoe.service.RightsService;
import info.csoe.utils.Utils;
import info.csoe.utils.rights.RightsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RightsService")
public class RightsServiceImpl implements RightsService {

    @Autowired
    private RightsDao rightsDao;

    @Override
    public RightsRes getAllRights(String type) {
        if (type.equals("list")) {
            List<Rights> rights = rightsDao.getAllRights();
            if (rights == null) {
                return Utils.buildRightsRes(null, Utils.buildMeta(404, "无权限数据"));
            }
            return Utils.buildRightsRes(rights, Utils.buildMeta(200, "获取权限列表成功"));
        }
        if (type.equals("tree")) {
            List<Rights> oneLayer = rightsDao.getRightsByPid(0);
            if (oneLayer == null) {
                return Utils.buildRightsRes(null, Utils.buildMeta(404, "无权限数据"));
            }
            for (Rights e : oneLayer) {
                List<Rights> second = rightsDao.getRightsByPid(e.getPs_id());
                if (second != null) {
                    e.setChildren(second);
                    for (Rights right : second) {
                        List<Rights> three = rightsDao.getRightsByPid(e.getPs_id());
                        if (three != null) {
                            right.setChildren(three);
                        }
                    }
                }
            }
            return Utils.buildRightsRes(oneLayer, Utils.buildMeta(200, "获取权限列表成功"));
        }
        return Utils.buildRightsRes(null, Utils.buildMeta(404, "传入的参数错误"));
    }

    @Override
    public RightsRes getMenus() {
        List<Rights> oneLayer = rightsDao.getRightsByPid(0);
        if (oneLayer == null) {
            return Utils.buildRightsRes(null, Utils.buildMeta(404, "无数据"));
        }
        for (Rights e : oneLayer) {
            List<Rights> second = rightsDao.getRightsByPidAndLevel(e.getPs_id(), "1");
            if (second != null) {
                e.setChildren(second);
            }
        }
        return Utils.buildRightsRes(oneLayer, Utils.buildMeta(200, "获取菜单数据成功"));
    }
}
