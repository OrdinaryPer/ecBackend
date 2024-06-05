package info.csoe.service;

import info.csoe.bean.Goods;
import info.csoe.utils.goods.GoodsListRes;
import info.csoe.utils.goods.GoodsOneRes;

public interface GoodsService {

    GoodsListRes getGoodsList(String query,Integer pageNum,Integer pageSize);

    GoodsOneRes getGoodsById(Integer id);

    GoodsOneRes insertGoods(Goods good);

    GoodsOneRes updateGoods(Goods good);

    GoodsOneRes deleteGoods(Integer id);
}
