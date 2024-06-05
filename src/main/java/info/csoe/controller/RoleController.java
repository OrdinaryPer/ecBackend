package info.csoe.controller;

import info.csoe.bean.Roles;
import info.csoe.service.RightsService;
import info.csoe.service.RoleService;
import info.csoe.utils.role.RoleAllRightsRes;
import info.csoe.utils.role.RoleListRes;
import info.csoe.utils.role.RoleOneRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RoleController {

    @Autowired
    private RoleService roleService;


    // 角色列表
    @GetMapping("/roles")
    public RoleListRes getAllRoles() {
        return roleService.getAllRoles();
    }

    // 根据 ID 查询角色
    @GetMapping("/roles/{id}")
    public RoleOneRes getRoleById(@PathVariable("id") Integer id) {
        return roleService.getRoleById(id);
    }

    // 添加角色
    @PostMapping("/roles")
    public RoleOneRes insertRole(@RequestBody Roles roles) {
       return roleService.insertRole(roles);
    }

    // 编辑提交角色
    @PutMapping("/roles/{id}")
    public RoleOneRes updateRole(@PathVariable("id") Integer id,
                                 @RequestBody Roles roles) {
        return roleService.updateRoleById(id, roles.getRole_name(), roles.getRole_desc());
    }

    // 删除角色
    @DeleteMapping("/roles/{id}")
    public RoleOneRes deleteRoleById(@PathVariable("id") Integer id) {
        return roleService.removeRoleById(id);
    }

    // 角色授权
    @PostMapping("/roles/{roleId}/rights")
    public RoleOneRes giveRoleToRight(@PathVariable("roleId") Integer id,
                                      @RequestBody Roles roles) {
        System.out.println(roles);
        return roleService.giveRoleToRight(id, roles.getPs_ids());
    }

    // 删除角色指定权限
    @DeleteMapping("/roles/{roleId}/rights/{rightId}")
    public RoleAllRightsRes deleteRoleSpecialRight(@PathVariable("roleId") Integer roleId,
                                                   @PathVariable("rightId") String rightId) {
        return roleService.deleteSpecialRightById(roleId, rightId);
    }
}
