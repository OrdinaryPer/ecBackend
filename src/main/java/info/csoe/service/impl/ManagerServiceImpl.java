package info.csoe.service.impl;

import info.csoe.bean.Manager;
import info.csoe.dao.ManagerDao;
import info.csoe.service.ManagerService;
import info.csoe.utils.Meta;
import info.csoe.utils.Utils;
import info.csoe.utils.manager.ManagerList;
import info.csoe.utils.manager.ManagerListRes;
import info.csoe.utils.manager.ManagerRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public ManagerListRes getAllManager(String query, int pageNum, int pageSize) {
        int start = (pageNum - 1) * pageSize;
        List<Manager> allManager = managerDao.getAllManager(query, start, pageSize);
        if (allManager == null) {
            return Utils.buildManagerListRes(null, Utils.buildMeta(404,"没有指定数据"));
        }
        // 根据 int 值将状态改为 boolean 值
        for (Manager m : allManager) {
            if (m.getMg_state_o() == null) {
                m.setMg_state_o(1);
                m.setMg_state(true);
            } else if (m.getMg_state_o() == 1) {
                m.setMg_state(true);
            } else if (m.getMg_state_o() == 0) {
                m.setMg_state(false);
            }
        }
        Integer count = managerDao.getAllManagerCount(query);
        if (count == null) {
            return Utils.buildManagerListRes(null, Utils.buildMeta(404,"没有指定数据"));
        }
        return Utils.buildManagerListRes(Utils.buildManagerList(count, pageNum, allManager),
                Utils.buildMeta(200,"获取成功"));
    }

    @Override
    public ManagerRes getOneManagerById(Integer id, String msg) {
        if (msg == null) {
            msg = "获取成功";
        }
        Manager manager = managerDao.getOneManagerById(id);
        if (manager == null) {
            return Utils.buildManagerRes(null, Utils.buildMeta(404, "该用户不存在"));
        }
        if (manager.getMg_state_o() == null || manager.getMg_state_o() == 1) {
            manager.setMg_state(true);
        } else {
            manager.setMg_state(false);
        }
        return Utils.buildManagerRes(manager, Utils.buildMeta(200, msg));
    }

    @Override
    public ManagerRes insertOneManager(Manager manager) {
        // 插入用户时必须有创建用户的时间戳信息
        manager.setMg_time(System.currentTimeMillis() / 1000);
        System.out.println("------");
        System.out.println(manager);
        System.out.println("------");
        Integer result = managerDao.insertOneManager(manager);
        if (result != 1) {
            return Utils.buildManagerRes(null, Utils.buildMeta(422, "添加用户失败"));
        }
        return this.getOneManagerById(manager.getMg_id(), "添加用户成功");
    }

    @Override
    public ManagerRes updateManagerState(Integer uid, String state) {
        // 传入的 state 是布尔类型字符串
        Integer newState = state.equals("true") ? 1 : 0;
        Integer result = managerDao.updateManagerState(uid, newState);
        if (result != 1) {
            return Utils.buildManagerRes(null, Utils.buildMeta(422, "修改用户状态失败"));
        }
        return this.getOneManagerById(uid, "修改用户状态成功");
    }

    @Override
    public ManagerRes updateManager(Integer id, String email, String mobile) {
        Integer result = managerDao.updateManager(id, email, mobile);
        if (result != 1) {
            return Utils.buildManagerRes(null, Utils.buildMeta(422, "修改用户信息失败"));
        }
        return this.getOneManagerById(id, "修改成功");
    }

    @Override
    public ManagerRes deleteManagerById(Integer id) {
        Integer result = managerDao.deleteManagerById(id);
        if (result != 1) {
            return Utils.buildManagerRes(null, Utils.buildMeta(422, "删除用户失败"));
        }
        return Utils.buildManagerRes(null, Utils.buildMeta(200, "删除成功"));
    }

    @Override
    public ManagerRes assignRoleById(Integer id, Integer role_id) {
        Integer result = managerDao.assignRoleById(id, role_id);
        if (result != 1) {
            return Utils.buildManagerRes(null, Utils.buildMeta(422, "分配权限失败"));
        }
        return this.getOneManagerById(id, "分配权限成功");
    }

    /*





    @Override
    public Integer getAllManagerCount() {
        return managerDao.getAllManagerCount();
    }*/
}
