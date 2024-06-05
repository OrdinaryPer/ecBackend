package info.csoe.bean;

import lombok.Data;

import java.util.List;

@Data
public class Rights {
    private Integer ps_id;
    private String ps_name;
    private String ps_level;
    private Integer ps_pid;
    private String ps_api_path;
    private List<Rights> children;
}
