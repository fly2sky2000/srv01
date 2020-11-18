package com.cameo.srv01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cameo.**.mapper")
public class Srv01Application {

    public static void main(String[] args) {
        SpringApplication.run(Srv01Application.class, args);
    }

}
