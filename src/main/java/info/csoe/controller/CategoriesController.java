package info.csoe.controller;

import info.csoe.service.CategoriesService;
import info.csoe.utils.categories.CateAllRes;
import info.csoe.utils.categories.CateListRes;
import info.csoe.utils.categories.CateOneRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    // 商品分类数据列表
    @GetMapping("/categories")
    public CateAllRes getAllCategories(@RequestParam(value = "type", required = false) Integer[] type,
                                       @RequestParam(value = "pagenum", required = false) Integer pageNum,
                                       @RequestParam(value = "pagesize", required = false) Integer pageSize) {
        return categoriesService.getAllCategories(type, pageNum, pageSize);
    }

    // 根据 id 查询分类
    @GetMapping("/categories/{id}")
    public CateOneRes getCategoryById(@PathVariable("id") Integer id) {
        return categoriesService.getCategoriesById(id);
    }

    // 添加分类
    @PostMapping("/categories")
    public CateOneRes insertCategory(@RequestParam("cat_pid") Integer pid,
                                       @RequestParam("cat_name") String name,
                                       @RequestParam("cat_level") Integer level) {
       return categoriesService.insertCategories(pid, name, level);
    }

    // 编辑提交分类
    @PutMapping("/categories/{id}")
    public CateOneRes updateCategory(@PathVariable("id") Integer id,
                                     @RequestParam("cat_name") String name) {
        return categoriesService.updateCategoriesById(id, name);
    }

    // 删除分类
    @DeleteMapping("/categories/{id}")
    public CateOneRes deleteCategory(@PathVariable("id") Integer id) {
        return categoriesService.deleteCategoriesById(id);
    }
}
