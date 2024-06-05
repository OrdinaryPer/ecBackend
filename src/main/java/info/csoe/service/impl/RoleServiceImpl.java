package info.csoe.service.impl;

import info.csoe.bean.Rights;
import info.csoe.bean.Roles;
import info.csoe.dao.RightsDao;
import info.csoe.dao.RoleDao;
import info.csoe.service.RoleService;
import info.csoe.utils.Utils;
import info.csoe.utils.role.RoleAllRightsRes;
import info.csoe.utils.role.RoleListRes;
import info.csoe.utils.role.RoleOneRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RightsDao rightsDao;

    @Override
    public RoleListRes getAllRoles() {
        List<Roles> roles = roleDao.getAllRoles();
        if (roles == null) {
            return Utils.buildRoleListRes(null, Utils.buildMeta(404, "无角色信息"));
        }
        for (Roles e : roles) {
            String idStr = e.getPs_ids();
            if (idStr != null && !idStr.equals("")) {
                String[] ids = idStr.split(",");
                List<Rights> oneLayer = new ArrayList<>();
                List<Rights> secondLayer = new ArrayList<>();
                List<Rights> threeLayer = new ArrayList<>();
                // 获取单个角色所有的权限
                for (String id : ids) {
                    Rights right = rightsDao.getRightById(Integer.valueOf(id));
                    if (right != null) {
                        if (right.getPs_level().equals("0")) {
                            oneLayer.add(right);
                        } else if (right.getPs_level().equals("1")) {
                            secondLayer.add((right));
                        } else if (right.getPs_level().equals("2")) {
                            threeLayer.add(right);
                        }
                    }
                }
                for (Rights second : secondLayer) {
                    List<Rights> threeChidren = new ArrayList<>();
                    if (threeLayer.size() > 0) {
                        for (Rights three: threeLayer) {
                            if (three.getPs_pid().equals(second.getPs_id())) {
                                threeChidren.add(three);
                            }
                        }
                        threeChidren.removeAll(threeChidren);
                        second.setChildren(threeChidren);
                    }
                }
                for (Rights one : oneLayer) {
                    List<Rights> secondChidren = new ArrayList<>();
                    if (secondLayer.size() > 0) {
                        for (Rights second: secondLayer) {
                            if (second.getPs_pid().equals(one.getPs_id())) {
                                secondChidren.add(second);
                            }
                        }
                        secondLayer.removeAll(secondChidren);
                        one.setChildren(secondChidren);
                    }
                }
                e.setChildren(oneLayer);
            }
        }
        return Utils.buildRoleListRes(roles, Utils.buildMeta(200, "获取成功"));
    }

    @Override
    public RoleOneRes getRoleById(Integer id) {
        Roles role = roleDao.getRoleById(id);
        if (role == null) {
            return Utils.buildRoleOneRes(null, Utils.buildMeta(404,"角色信息不存在"));
        }
        return Utils.buildRoleOneRes(role, Utils.buildMeta(200,"获取成功"));
    }

    @Override
    public RoleOneRes insertRole(Roles roles) {
        System.out.println();
        System.out.println(roles);
        System.out.println();
        Integer result = roleDao.insertRole(roles);
        if (result != 1) {
            return Utils.buildRoleOneRes(null, Utils.buildMeta(404,"添加角色失败"));
        }
        return this.getRoleById(roles.getRole_id());
    }


    @Override
    public RoleOneRes updateRoleById(Integer id, String name, String desc) {
        Integer result = roleDao.updateRoleById(id, name, desc);
        if (result != 1) {
            return Utils.buildRoleOneRes(null, Utils.buildMeta(404,"修改角色信息失败"));
        }
        return this.getRoleById(id);
    }

    @Override
    public RoleOneRes removeRoleById(Integer id) {
        Integer result = roleDao.removeRoleById(id);
        if (result != 1) {
            return Utils.buildRoleOneRes(null, Utils.buildMeta(404,"删除角色失败"));
        }
        return Utils.buildRoleOneRes(null, Utils.buildMeta(200,"删除角色成功"));
    }

    @Override
    public RoleOneRes giveRoleToRight(Integer id, String rids) {
        Integer result = roleDao.giveRoleToRight(id, rids);
        if (result != 1) {
            return Utils.buildRoleOneRes(null, Utils.buildMeta(404,"角色授权失败"));
        }
        return Utils.buildRoleOneRes(null, Utils.buildMeta(200,"角色授权成功"));
    }

    @Override
    public RoleAllRightsRes deleteSpecialRightById(Integer roleId, String rightId) {
        Roles role = roleDao.getRoleById(roleId);
        if (role == null) {
            return Utils.buildRoleAllRightsRes(null, Utils.buildMeta(404,"该角色不存在"));
        }
        String idStr = role.getPs_ids();
        if (idStr == null || idStr.equals("") || !idStr.contains(rightId)) {
            return Utils.buildRoleAllRightsRes(null, Utils.buildMeta(404,"该角色不存在指定权限"));
        }
        String[] ids = idStr.split(",");
        String[] newIds = new String[ids.length - 1];
        int count = 0;
        for (String id : ids) {
            if (!id.equals(rightId)) {
                newIds[count++] = id;
            }
        }
        String newIdStr = String.join(",", newIds);
        Integer result = roleDao.giveRoleToRight(roleId, newIdStr);
        if (result != 1) {
            return Utils.buildRoleAllRightsRes(null, Utils.buildMeta(404,"删除角色权限失败"));
        }
        List<Rights> oneLayer = new ArrayList<>();
        List<Rights> secondLayer = new ArrayList<>();
        List<Rights> threeLayer = new ArrayList<>();
        // 获取单个角色所有的权限，newIds
        for (String id : newIds) {
            Rights right = rightsDao.getRightById(Integer.valueOf(id));
            if (right != null) {
                if (right.getPs_level().equals("0")) {
                    oneLayer.add(right);
                } else if (right.getPs_level().equals("1")) {
                    secondLayer.add((right));
                } else if (right.getPs_level().equals("2")) {
                    threeLayer.add(right);
                }
            }
        }
        for (Rights second : secondLayer) {
            List<Rights> threeChidren = new ArrayList<>();
            if (threeLayer.size() > 0) {
                for (Rights three: threeLayer) {
                    if (three.getPs_pid().equals(second.getPs_id())) {
                        threeChidren.add(three);
                    }
                }
                threeChidren.removeAll(threeChidren);
                second.setChildren(threeChidren);
            }
        }
        for (Rights one : oneLayer) {
            List<Rights> secondChidren = new ArrayList<>();
            if (secondLayer.size() > 0) {
                for (Rights second: secondLayer) {
                    if (second.getPs_pid().equals(one.getPs_id())) {
                        secondChidren.add(second);
                    }
                }
                secondLayer.removeAll(secondChidren);
                one.setChildren(secondChidren);
            }
        }
        return Utils.buildRoleAllRightsRes(oneLayer, Utils.buildMeta(200,"删除角色权限成功"));
    }
}
