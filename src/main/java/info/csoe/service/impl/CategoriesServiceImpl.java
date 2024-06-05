package info.csoe.service.impl;

import info.csoe.bean.Categories;
import info.csoe.dao.CategoriesDao;
import info.csoe.service.CategoriesService;
import info.csoe.utils.Utils;
import info.csoe.utils.categories.CateAllRes;
import info.csoe.utils.categories.CateListRes;
import info.csoe.utils.categories.CateOneRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoriesService")
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesDao categoriesDao;

    @Override
    public CateAllRes getAllCategories(Integer[] type, Integer pageNum, Integer pageSize) {
        // 无参数时，获取所有
        if (type == null || pageNum == null || pageSize == null) {
            // 获取第一层级的所有分类
            List<Categories> categories = categoriesDao
                    .getCategoriesByLevelAndLimit(null, null, 0);
            if (categories == null) {
                return Utils.buildCateAllRes(null, null, Utils.buildMeta(404,"分类数据为空"));
            }
            List<Categories> total = null;
            total.addAll(categories);
            // 获取第二层级的分类
            for (Categories one : categories) {
                List<Categories> two = categoriesDao.getCategoriesByLevelAndPid(1, one.getCat_id());
                if (two != null) {
                    one.setChildren(two);
                    total.addAll(two);
                    // 获取第三层级
                    for (Categories second : two) {
                        List<Categories> three = categoriesDao
                                .getCategoriesByLevelAndPid(2, second.getCat_id());
                        if (three != null) {
                            second.setChildren(three);
                            total.addAll(three);
                        }
                    }
                }
            }
            // 获取所有数据的个数
            Integer all = categoriesDao.countAll();
            return Utils.buildCateAllRes(total, all, Utils.buildMeta(200,"获取成功"));
        }
        List<Categories> first = categoriesDao
                .getCategoriesByLevelAndLimit((pageNum - 1) * pageSize, pageSize, 0);
        Integer level0 = categoriesDao.countByCatLevel(0);
        if (first == null) {
            return Utils.buildCateAllRes(null, level0, Utils.buildMeta(404,"分类数据为空"));
        }
        if (type.length == 1) {
            return Utils.buildCateAllRes(first, level0,Utils.buildMeta(200,"获取成功"));
        }
        for (Categories one : first) {
            List<Categories> second = categoriesDao.getCategoriesByLevelAndPid(1, one.getCat_id());
            if (second != null) {
                one.setChildren(second);
                if (type.length == 3) {
                    for (Categories se : second) {
                        List<Categories> threes = categoriesDao.getCategoriesByLevelAndPid(2, se.getCat_id());
                        if (threes != null) {
                            se.setChildren(threes);
                        }
                    }
                }
            }
        }
        return Utils.buildCateAllRes(first, level0,Utils.buildMeta(200,"获取成功"));
    }

    @Override
    public CateOneRes getCategoriesById(Integer id) {
        Categories cate = categoriesDao.getCategoriesById(id);
        if (cate == null) {
            return Utils.buildCateOneRes(null, Utils.buildMeta(404,"不存在该分类"));
        }
        return Utils.buildCateOneRes(cate, Utils.buildMeta(200,"获取成功"));
    }


    @Override
    public CateOneRes insertCategories(Integer pid, String name, Integer level) {
        Categories categories = new Categories();
        categories.setCat_pid(pid);
        categories.setCat_name(name);
        categories.setCat_level(level);
        Integer result = categoriesDao.insertCategories(categories);
        if (result == null) {
            return Utils.buildCateOneRes(null, Utils.buildMeta(404,"添加分类失败"));
        }
        return this.getCategoriesById(categories.getCat_id());
    }

    @Override
    public CateOneRes updateCategoriesById(Integer id, String name) {
        Integer result = categoriesDao.updateCategoriesById(id, name);
        if (result != 1) {
            return Utils.buildCateOneRes(null, Utils.buildMeta(404,"修改分类失败"));
        }
        return this.getCategoriesById(id);
    }

    @Override
    public CateOneRes deleteCategoriesById(Integer id) {
        Integer result = categoriesDao.deleteCategoriesById(id);
        if (result != 1) {
            return Utils.buildCateOneRes(null, Utils.buildMeta(404,"删除分类失败"));
        }
        return Utils.buildCateOneRes(null, Utils.buildMeta(200,"删除分类成功"));
    }







}
