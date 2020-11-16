package com.zzt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan("com.zzt.scan")
public class MyComponentScan {

    @Configuration
    @Order(90)
    class InnerClass {

    }

}
