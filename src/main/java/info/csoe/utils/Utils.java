package info.csoe.utils;

import info.csoe.bean.*;
import info.csoe.utils.attribute.AttrListRes;
import info.csoe.utils.attribute.AttrOneRes;
import info.csoe.utils.categories.CateAllRes;
import info.csoe.utils.categories.CateList;
import info.csoe.utils.categories.CateListRes;
import info.csoe.utils.categories.CateOneRes;
import info.csoe.utils.goods.GoodsData;
import info.csoe.utils.goods.GoodsList;
import info.csoe.utils.goods.GoodsListRes;
import info.csoe.utils.goods.GoodsOneRes;
import info.csoe.utils.manager.ManagerList;
import info.csoe.utils.manager.ManagerListRes;
import info.csoe.utils.manager.ManagerRes;
import info.csoe.utils.rights.RightsRes;
import info.csoe.utils.role.RoleAllRightsRes;
import info.csoe.utils.role.RoleListRes;
import info.csoe.utils.role.RoleOneRes;

import java.util.List;

public class Utils {

    public static Meta buildMeta(Integer statusCode, String msg) {
        return new Meta(msg, statusCode);
    }

    public static ManagerList buildManagerList(int totalPage, int numPage, List<Manager> users) {
        return new ManagerList(totalPage, numPage, users);
    }

    public static ManagerListRes buildManagerListRes(ManagerList list, Meta meta) {
        ManagerListRes res = new ManagerListRes();
        res.data = list;
        res.meta = meta;
        return res;
    }

    public static ManagerRes buildManagerRes(Manager manager, Meta meta) {
        ManagerRes res = new ManagerRes();
        res.data = manager;
        res.meta = meta;
        return res;
    }

    public static RightsRes buildRightsRes(List<Rights> rights, Meta meta) {
        RightsRes res = new RightsRes();
        res.data = rights;
        res.meta = meta;
        return res;
    }

    public static RoleListRes buildRoleListRes(List<Roles> roles, Meta meta) {
        RoleListRes res = new RoleListRes();
        res.data = roles;
        res.meta = meta;
        return res;
    }

    public static RoleOneRes buildRoleOneRes(Roles roles, Meta meta) {
        RoleOneRes res = new RoleOneRes();
        res.meta = meta;
        res.data = roles;
        return res;
    }

    public static RoleAllRightsRes buildRoleAllRightsRes(List<Rights> rights, Meta meta) {
        RoleAllRightsRes res = new RoleAllRightsRes();
        res.data = rights;
        res.meta = meta;
        return res;
    }

    public static CateListRes buildCateListRes(List<Categories> categories, Meta meta) {
        CateListRes res = new CateListRes();
        res.data = categories;
        res.meta = meta;
        return res;
    }

    public static CateOneRes buildCateOneRes(Categories categories, Meta meta) {
        CateOneRes res = new CateOneRes();
        res.meta = meta;
        res.data = categories;
        return res;
    }

    public static AttrListRes buildAttrListRes(List<Attribute> attributes, Meta meta) {
        AttrListRes res = new AttrListRes();
        res.data = attributes;
        res.meta = meta;
        return res;
    }

    public static AttrOneRes buildAttrOneRes(Attribute attribute, Meta meta) {
        AttrOneRes res = new AttrOneRes();
        res.data = attribute;
        res.meta = meta;
        return res;
    }

    public static GoodsList buildGoodsList(Integer total, String page, List<Goods> goods) {
        GoodsList list = new GoodsList();
        list.goods = goods;
        list.total = total;
        list.pagenum = page;
        return list;
    }

    public static GoodsData buildGoodsData(Goods goods, List<GoodsPhotos> photos, List<GoodsAttribute> attributes) {
        GoodsData data = new GoodsData();
        data.goods_id = goods.getGoods_id();
        data.goods_name = goods.getGoods_name();
        data.goods_price = goods.getGoods_price();
        data.goods_introduce = goods.getGoods_introduce();
        data.goods_big_logo = goods.getGoods_big_logo();
        data.goods_small_logo = goods.getGoods_small_logo();
        data.goods_state = goods.getGoods_state();
        data.goods_number = goods.getGoods_number();
        data.goods_weight = goods.getGoods_weight();
        data.add_time = goods.getAdd_time();
        data.upd_time = goods.getUpd_time();
        data.hot_mumber = goods.getHot_mumber();
        data.is_promote = goods.getIs_promote();
        data.pics = photos;
        data.attrs = attributes;
        return data;
    }

    public static GoodsListRes buildGoodsListRes(GoodsList list, Meta meta) {
        GoodsListRes res = new GoodsListRes();
        res.data = list;
        res.meta = meta;
        return res;
    }

    public static GoodsOneRes buildGoodsOneRes(GoodsData goodsData, Meta meta) {
        GoodsOneRes res = new GoodsOneRes();
        res.data = goodsData;
        res.meta = meta;
        return res;
    }

    public static CateAllRes buildCateAllRes(List<Categories> list, Integer total, Meta meta) {
        CateList cateList = new CateList();
        cateList.result = list;
        cateList.total = total;
        CateAllRes res = new CateAllRes();
        res.data = cateList;
        res.meta = meta;
        return res;
    }
}
