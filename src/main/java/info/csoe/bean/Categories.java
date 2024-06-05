package info.csoe.bean;

import lombok.Data;

import java.util.List;

@Data
public class Categories {
    private Integer cat_id;
    private String cat_name;
    private Integer cat_pid;
    private Integer cat_level;
    private Integer cat_deleted;
    private List<Categories> children;
}
