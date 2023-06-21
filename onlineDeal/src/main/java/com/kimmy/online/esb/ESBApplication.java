package com.kimmy.online.esb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: TODO
 * @author: liyq
 * @createtime: 2023-06-16 16:04
 */
// @MapperScan(basePackages = {"com.kimmy.online.esb.mapper"})
@SpringBootApplication
public class ESBApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ESBApplication.class, args);
    }

}
