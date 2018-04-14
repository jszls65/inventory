package com.zls.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Springboot 启动类
 */
@SpringBootApplication
public class MainApplication  /*extends SpringBootServletInitializer*/ {

/*

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApplication.class);
    }
*/


    public static void main(String[] args) throws Exception{
        SpringApplication.run(MainApplication.class, args);
    }
}
