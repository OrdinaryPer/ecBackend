package info.csoe.service;

import info.csoe.bean.Manager;
import info.csoe.utils.manager.ManagerListRes;
import info.csoe.utils.manager.ManagerRes;
import org.apache.ibatis.annotations.Param;

public interface ManagerService {

//    List<Manager> getAllManager(int pageNum, int pageSize);
    //    Integer getAllManagerCount();

    ManagerListRes getAllManager(String query, int pageNum, int pageSize);
    ManagerRes getOneManagerById(Integer id, String msg);
    ManagerRes insertOneManager(Manager manager);
    ManagerRes updateManagerState(Integer uid, String state);
    ManagerRes updateManager(Integer id, String email, String mobile);
    ManagerRes deleteManagerById(Integer id);
    ManagerRes assignRoleById(Integer id,Integer role_id);
}
