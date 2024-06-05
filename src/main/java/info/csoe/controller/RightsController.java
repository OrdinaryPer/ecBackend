package info.csoe.controller;

import info.csoe.service.RightsService;
import info.csoe.utils.rights.RightsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RightsController {

    @Autowired
    private RightsService rightsService;

    // 所有权限列表
    @GetMapping("/rights/{type}")
    public RightsRes getAllRights(@PathVariable("type") String type) {
       return rightsService.getAllRights(type);
    }

    // 左侧菜单权限
    @GetMapping("/menus")
    public RightsRes getMemus() {
       return  rightsService.getMenus();
    }
}
