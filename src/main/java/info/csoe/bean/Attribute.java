package info.csoe.bean;

import lombok.Data;

@Data
public class Attribute {

    private Integer attr_id;
    private String attr_name;
    private Integer cat_id;
    private String attr_sel;
    private String attr_write;
    private String attr_vals;

    private Integer goods_id;

}
