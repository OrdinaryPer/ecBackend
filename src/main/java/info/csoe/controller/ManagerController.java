package info.csoe.controller;

import info.csoe.bean.Manager;
import info.csoe.service.ManagerService;
import info.csoe.utils.manager.ManagerListRes;
import info.csoe.utils.manager.ManagerRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ManagerController {

    @Autowired
    private ManagerService managerService;



    // 用户数据列表
    @GetMapping("/users")
    public ManagerListRes getAllManager(@RequestParam("pagenum") Integer pageNum,
                                        @RequestParam("pagesize") Integer pageSize,
                                        @RequestParam(value = "query", required = false) String query) {
        return managerService.getAllManager(query, pageNum, pageSize);
    }

    // 根据 ID 查询用户信息
    @GetMapping("/users/{id}")
    public ManagerRes getOneManagerById(@PathVariable("id") Integer id) {
        return managerService.getOneManagerById(id, null);
    }

    // 添加用户
    @PostMapping("/users")
    public ManagerRes insertOneManager(@RequestBody Manager manager) {
        return managerService.insertOneManager(manager);
    }

    // 修改用户状态
    @CrossOrigin
    @PutMapping("/users/{uid}/state/{type}")
    public ManagerRes updateManagerState(@PathVariable("uid") Integer id,
                                  @PathVariable("type") String state) {
        return managerService.updateManagerState(id, state);
    }

    // 编辑用户提交
    @PutMapping("/users/{id}")
    public ManagerRes updateManager(@PathVariable("id") Integer id,
                         @RequestBody Manager manager) {
        return managerService.updateManager(id, manager.getMg_email(), manager.getMg_mobile());
    }

    // 删除单个用户
    @DeleteMapping("/users/{id}")
    public ManagerRes deleteManagerById(@PathVariable("id") Integer id) {
        return managerService.deleteManagerById(id);
    }

    // 分配用户角色
    @PutMapping("/users/{id}/role")
    public ManagerRes assignRoleById(@PathVariable("id") Integer id,
                                     @RequestBody Manager manager) {
        return managerService.assignRoleById(id, Integer.valueOf(manager.getRid()));
    }

}
