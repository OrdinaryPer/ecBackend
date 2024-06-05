package info.csoe.dao;

import info.csoe.bean.Categories;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoriesDao {
    List<Categories> getAllCategories(@Param("start") Integer startPage,
                                      @Param("size") Integer pageSize);
    List<Categories> getCategoriesByLevelAndLimit(@Param("start") Integer startPage,
                                                  @Param("size") Integer pageSize,
                                                  @Param(("level")) Integer level);
    List<Categories> getCategoriesByLevelAndPid(@Param(("level")) Integer level, @Param("pid") Integer pid);
    Categories getCategoriesById(@Param("id") Integer id);
    Integer insertCategories(Categories categories);
    Integer updateCategoriesById(@Param("id") Integer id,
                                 @Param("name") String name);
    Integer deleteCategoriesById(@Param("id") Integer id);
    Integer countAll();
    Integer countByCatLevel(@Param("level") Integer level);
}
