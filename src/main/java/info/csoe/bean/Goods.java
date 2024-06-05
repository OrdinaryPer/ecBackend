package info.csoe.bean;

import lombok.Data;

import java.util.List;

@Data
public class Goods {
    private Integer goods_id;
    private String goods_name;
    private Double goods_price;
    private Integer goods_number;
    private Integer goods_weight;
    private Integer goods_state;
    private Long add_time;
    private Long upd_time;
    private Integer hot_mumber;
    private Integer is_promote;

    private String goods_introduce;
    private String goods_big_logo;
    private String goods_small_logo;

    private Integer cat_id;

    private Integer cat_one_id;
    private Integer cat_two_id;
    private Integer cat_three_id;

    private String goods_cat;

    private List<GoodsPhotos> pics;
    private List<GoodsAttribute> atts;


}
