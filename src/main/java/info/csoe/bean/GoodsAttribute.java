package info.csoe.bean;

import lombok.Data;

@Data
public class GoodsAttribute {
    private Integer id;
    private Integer goods_id;
    private Integer attr_id;
    private String attr_value;
    private Double add_price;

    private String attr_name;
    private String attr_sel;
    private String attr_write;
    private String attr_vals;

}
