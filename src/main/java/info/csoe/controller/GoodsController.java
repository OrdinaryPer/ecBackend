package info.csoe.controller;

import info.csoe.bean.Goods;
import info.csoe.service.GoodsService;
import info.csoe.utils.goods.GoodsListRes;
import info.csoe.utils.goods.GoodsOneRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@CrossOrigin(origins = "*")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    // 商品列表数据
    @GetMapping("")
    public GoodsListRes getGoodsList(@RequestParam(value = "query", required = false) String query,
                                     @RequestParam("pagenum") Integer pageNum,
                                     @RequestParam("pagesize") Integer pageSize) {
        // 查询开始位置是 (pageNum - 1) * pageSize
        return goodsService.getGoodsList(query, pageNum, pageSize);
    }

    // 根据 ID 查询商品
    @GetMapping("/{id}")
    public GoodsOneRes getGoodsById(@PathVariable("id") Integer id) {
        return goodsService.getGoodsById(id);
    }

    // 添加商品
    @PostMapping("")
    public GoodsOneRes insertGoods(@RequestBody Goods goods) {
        return goodsService.insertGoods(goods);
    }

    // 编辑提交商品
    @PutMapping("/{id}")
    public GoodsOneRes updateGoods(@PathVariable("id") Integer id, @RequestBody Goods goods) {
        goods.setGoods_id(id);
        return goodsService.updateGoods(goods);
    }

    //  删除商品
    @DeleteMapping("/{id}")
    public GoodsOneRes deleteGoods(@PathVariable("id") Integer id) {
        return goodsService.deleteGoods(id);
    }
}
