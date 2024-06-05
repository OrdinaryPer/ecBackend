package info.csoe.service.impl;

import info.csoe.bean.Goods;
import info.csoe.bean.GoodsAttribute;
import info.csoe.bean.GoodsPhotos;
import info.csoe.dao.GoodsDao;
import info.csoe.service.GoodsService;
import info.csoe.utils.Meta;
import info.csoe.utils.Utils;
import info.csoe.utils.goods.GoodsListRes;
import info.csoe.utils.goods.GoodsOneRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public GoodsListRes getGoodsList(String query,Integer pageNum,Integer pageSize) {
        Integer count = goodsDao.getGoodsCount(query);
        if (count == 0) {
            return Utils.buildGoodsListRes(Utils.buildGoodsList(0, null, null),
                    Utils.buildMeta(200,"获取成功"));
        }
        List<Goods> list = goodsDao.getGoodsList(query, (pageNum - 1) * pageSize, pageSize);
        if (list == null) {
            return Utils.buildGoodsListRes(Utils.buildGoodsList(count, String.valueOf(pageNum), null),
                    Utils.buildMeta(404,"查询商品信息失败"));
        }
        return Utils.buildGoodsListRes(Utils.buildGoodsList(count, String.valueOf(pageNum), list),
                Utils.buildMeta(200,"获取成功"));
    }

    @Override
    public GoodsOneRes getGoodsById(Integer id) {
        Goods goods = goodsDao.getGoodsById(id);
        if (goods == null) {
            return Utils.buildGoodsOneRes(null, Utils.buildMeta(404,"该商品不存在"));
        }
        List<GoodsPhotos> photos = goodsDao.getGoodsPhotosByGid(id);
        List<GoodsAttribute> attributes = goodsDao.getGoodsAttributeByGid(id);
        return Utils.buildGoodsOneRes(Utils.buildGoodsData(goods, photos, attributes),
                Utils.buildMeta(200,"查询商品成功"));
    }

    @Override
    public GoodsOneRes insertGoods(Goods good) {
        String ids = good.getGoods_cat();
        if (!ids.contains(",")) {
            Integer id = Integer.valueOf(ids);
            good.setCat_id(id);
            good.setCat_one_id(id);
        }
        String[] catIds = ids.split(",");
        Integer catId = Integer.valueOf(catIds[catIds.length - 1]);
        good.setCat_id(catId);
        // 一级和二级分类 id
        good.setCat_one_id(Integer.valueOf(catIds[0]));
        good.setCat_two_id(Integer.valueOf(catIds[1]));
        Long time = System.currentTimeMillis() / 1000;
        good.setAdd_time(time);
        good.setUpd_time(time);
        if (catIds.length == 3) {
            good.setCat_three_id(catId);
        }
        Integer firstInserted = goodsDao.insertGoods(good);
        if (firstInserted == null) {
            return Utils.buildGoodsOneRes(null, Utils.buildMeta(404,"添加商品失败"));
        }
        List<GoodsPhotos> pics = good.getPics();
        if (pics != null) {
            for (GoodsPhotos p : pics) {
                Integer insertedPhoto = goodsDao.insertGoodsPic(p);
                if (insertedPhoto == null) {
                    return Utils.buildGoodsOneRes(null, Utils.buildMeta(404,"添加商品图片失败"));
                }
            }
        }
        List<GoodsAttribute> atts = good.getAtts();
        if (atts != null) {
            for (GoodsAttribute att : atts) {
                Integer insertedAttr = goodsDao.updateGoodsAttr(att.getAttr_id(), att.getAttr_vals());
                if (insertedAttr == null) {
                    return Utils.buildGoodsOneRes(null, Utils.buildMeta(404,"添加商品属性失败"));
                }
            }
        }
        return this.getGoodsById(good.getGoods_id());
    }

    @Override
    public GoodsOneRes updateGoods(Goods good) {
        Integer result = goodsDao.updateGoods(good);
        if (result != 1) {
            return Utils.buildGoodsOneRes(null, Utils.buildMeta(404,"修改失败"));
        }
        return this.getGoodsById(good.getGoods_id());
    }

    @Override
    public GoodsOneRes deleteGoods(Integer id) {
        Integer result = goodsDao.deleteGoods(id);
        if (result != 1) {
            return Utils.buildGoodsOneRes(null, Utils.buildMeta(404,"删除商品失败"));
        }
        Integer photoResult = goodsDao.deleteGoodsPhotoByGoodsId(id);
//        if (photoResult <= 0) {
//            return Utils.buildGoodsOneRes(null, Utils.buildMeta(404,"删除商品图片失败"));
//        }
        Integer attrResult = goodsDao.deleteGoodsAttributeByGoodsId(id);
//        if (attrResult <= 0) {
//            return Utils.buildGoodsOneRes(null, Utils.buildMeta(404,"删除商品属性失败"));
//        }
        return Utils.buildGoodsOneRes(null, Utils.buildMeta(200,"删除成功"));
    }
}
