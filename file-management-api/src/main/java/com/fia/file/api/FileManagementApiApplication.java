package com.fia.file.api;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(annotationClass = Mapper.class, basePackages = {"com.fia.file.dao"})
@ComponentScan("com.fia.file")
public class FileManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileManagementApiApplication.class, args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
