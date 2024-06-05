package info.csoe.utils.goods;

import info.csoe.bean.GoodsAttribute;
import info.csoe.bean.GoodsPhotos;

import java.util.List;

public class GoodsData {
    public Integer goods_id;
    public String goods_name;
    public Double goods_price;
    public Integer goods_number;
    public Integer goods_weight;
    public Integer goods_state;
    public Long add_time;
    public Long upd_time;
    public Integer hot_mumber;
    public Integer is_promote;

    public String goods_introduce;
    public String goods_big_logo;
    public String goods_small_logo;
    public List<GoodsPhotos> pics;
    public List<GoodsAttribute> attrs;


}
