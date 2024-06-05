package info.csoe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8081");
        configuration.addAllowedHeader("Authorization,Content-Type"); // 允许的请求头
        configuration.addAllowedMethod("GET,POST,DELETE,PUT,PATCH,OPTIONS"); // 允许的请求方法
        configuration.setAllowCredentials(true); // 是否允许发送 cookie
        System.out.println("跨域开启");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 对所有路径应用配置

        return new CorsFilter(source);
    }
}
