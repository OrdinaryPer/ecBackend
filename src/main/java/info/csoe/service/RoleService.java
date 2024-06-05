package info.csoe.service;

import info.csoe.bean.Roles;
import info.csoe.utils.role.RoleAllRightsRes;
import info.csoe.utils.role.RoleListRes;
import info.csoe.utils.role.RoleOneRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    RoleListRes getAllRoles();

    RoleOneRes getRoleById(Integer id);

    RoleOneRes insertRole(Roles roles);
    RoleOneRes updateRoleById(Integer id, String name, String desc);
    RoleOneRes removeRoleById(Integer id);
    RoleOneRes giveRoleToRight(Integer id, String rids);

    RoleAllRightsRes deleteSpecialRightById(Integer roleId, String rightId);
}
