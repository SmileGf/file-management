package com.fia.file.common.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 跨域问题
     * @param registry registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                // 1允许任何域名使用
                .allowedOrigins("*")
                // 2允许任何头
                .allowedHeaders("*")
                // 3允许任何方法（post、get等）
                .allowedMethods("*");
    }
}
