package info.csoe.dao;

import info.csoe.bean.Attribute;
import info.csoe.bean.Goods;
import info.csoe.bean.GoodsAttribute;
import info.csoe.bean.GoodsPhotos;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {

    List<Goods> getGoodsList(@Param("query") String query,
                             @Param("start") Integer start,
                             @Param("size") Integer size);
    Integer getGoodsCount(@Param("query") String query);

    Goods getGoodsById(@Param("id") Integer id);

    // 获取和商品关联的相册信息
    List<GoodsPhotos> getGoodsPhotosByGid(@Param("id") Integer id);

    // 获取和商品关联的属性信息
    List<GoodsAttribute> getGoodsAttributeByGid(@Param("id") Integer id);

    Integer insertGoods(Goods good);

    Integer insertGoodsPic(GoodsPhotos photos);

    Integer updateGoodsAttr(@Param("id") Integer id,
                            @Param("vals") String vals);

    Integer updateGoods(Goods good);

    Integer deleteGoods(@Param("id") Integer id);
    Integer deleteGoodsPhotoByGoodsId(@Param("id") Integer id);
    Integer deleteGoodsAttributeByGoodsId(@Param("id") Integer id);
}
