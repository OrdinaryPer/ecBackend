package info.csoe.service;

import info.csoe.bean.Categories;
import info.csoe.utils.categories.CateAllRes;
import info.csoe.utils.categories.CateListRes;
import info.csoe.utils.categories.CateOneRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoriesService {
    CateAllRes getAllCategories(Integer[] type, Integer pageNum, Integer pageSize);
    CateOneRes getCategoriesById(Integer id);
    CateOneRes insertCategories(Integer pid, String name, Integer level);
    CateOneRes updateCategoriesById(Integer id, String name);
    CateOneRes deleteCategoriesById(Integer id);
}
