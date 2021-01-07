package com.lxw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.lxw.mapper")
public class Jieye1Application {
    public static void main(String[] args) {
        SpringApplication.run(Jieye1Application.class, args);
    }

}
