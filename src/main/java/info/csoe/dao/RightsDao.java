package info.csoe.dao;

import info.csoe.bean.Rights;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RightsDao {
    List<Rights> getAllRights();
    Rights getRightById(@Param("id") Integer id);

    List<Rights> getRightsByPid(@Param("pid") Integer pid);
    List<Rights> getRightsByPidAndLevel(@Param("pid") Integer pid, @Param("level") String level);
}
