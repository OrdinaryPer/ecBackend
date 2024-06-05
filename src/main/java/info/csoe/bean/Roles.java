package info.csoe.bean;

import lombok.Data;

import java.util.List;

@Data
public class Roles {
    private Integer role_id;
    private String role_name;
    private String role_desc;
    private String ps_ids;
    private List<Rights> children;
}
