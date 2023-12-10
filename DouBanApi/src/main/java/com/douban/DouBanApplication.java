package com.douban;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

///http://localhost:8080/swagger-ui.html#/   start web path
@MapperScan("com.douban.mapper")
@SpringBootApplication
public class DouBanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DouBanApplication.class, args);
    }

}
