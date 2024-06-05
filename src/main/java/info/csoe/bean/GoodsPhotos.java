package info.csoe.bean;

import lombok.Data;

@Data
public class GoodsPhotos {
    private Integer pics_id;
    private Integer goods_id;
    private String pics_big;
    private String pics_mid;
    private String pics_sma;
}
