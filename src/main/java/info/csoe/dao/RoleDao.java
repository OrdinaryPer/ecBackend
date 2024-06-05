package info.csoe.dao;

import info.csoe.bean.Roles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    List<Roles> getAllRoles();
    Integer insertRole(Roles role);
    Roles getRoleById(@Param("id") Integer id);
    Integer updateRoleById(@Param("id") Integer id,
                           @Param("name") String name,
                           @Param("desc") String desc);
    Integer removeRoleById(@Param("id") Integer id);
    Integer giveRoleToRight(@Param("id") Integer id,
                            @Param("rids") String rids);
}
