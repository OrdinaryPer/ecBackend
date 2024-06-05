package info.csoe.controller;

import info.csoe.bean.Login;
import info.csoe.bean.Manager;
import info.csoe.dao.ManagerDao;
import info.csoe.utils.cors.JWT;
import info.csoe.utils.Utils;
import info.csoe.utils.manager.ManagerRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private ManagerDao managerDao;

    @PostMapping("/login")
    public ManagerRes login(@RequestBody Manager usp) {
//        System.out.println("login");
//        System.out.println(usp);
        Login login = new Login();
        login.setUsername(usp.getUsername());
        login.setPassword(usp.getPassword());
        //先到数据库验证
        Integer id = managerDao.login(login);
        if(id != null) {
            Manager manager = managerDao.getOneManagerById(id);
            //给用户jwt加密生成token
            String token = JWT.sign(login, 60L* 1000L* 30L);
            manager.setToken(token);
            return Utils.buildManagerRes(manager, Utils.buildMeta(200, "登录成功"));
        }
        return Utils.buildManagerRes(null, Utils.buildMeta(404, "登录失败"));
    }
}
