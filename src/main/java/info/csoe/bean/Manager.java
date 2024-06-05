package info.csoe.bean;


import lombok.Data;

@Data
public class Manager {
      private Integer mg_id;
      private String  mg_name;
      private String  mg_pwd;
      private Long mg_time;
      private Integer role_id;
      private Integer rid;
      private String mg_mobile;
      private String mg_email;
      private Boolean mg_state;
      private Integer mg_state_o;

      private String role_name;

      private String token;

      private String username;
      private String password;

}
