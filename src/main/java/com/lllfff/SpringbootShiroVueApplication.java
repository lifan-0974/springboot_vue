package com.lllfff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/lllfff/mapper")
public class SpringbootShiroVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiroVueApplication.class, args);
    }

}
