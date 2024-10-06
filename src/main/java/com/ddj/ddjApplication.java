package com.ddj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: icho
 * @Date: 2024/10/4 13:03
 * @Describe:
 */

@SpringBootApplication
@EnableScheduling
@MapperScan("com.ddj.mapper")
public class ddjApplication {
    public static void main(String[] args) {
        SpringApplication.run(ddjApplication.class, args);
    }
}
