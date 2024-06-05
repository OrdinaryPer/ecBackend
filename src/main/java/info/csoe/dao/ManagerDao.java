package info.csoe.dao;

import info.csoe.bean.Login;
import info.csoe.bean.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerDao {
    List<Manager> getAllManager(@Param("param") String param,
                                @Param("start") Integer start,
                                @Param("size") Integer size);
    Integer getAllManagerCount(@Param("query") String query);

    Manager getOneManagerById(@Param("id") Integer id);

    Integer insertOneManager(Manager manager);

    Integer updateManagerState(@Param("uid") Integer uid, @Param("state") Integer state);

    Integer updateManager(@Param("id") Integer id, @Param("email") String email, @Param("mobile") String mobile);

    Integer deleteManagerById(@Param("id") Integer id);

    Integer assignRoleById(@Param("id") Integer id,
                           @Param("role_id") Integer role_id);

    Integer login(Login login);
}
