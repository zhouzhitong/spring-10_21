package com.debug.config;

import com.debug.bean.Person;
import com.debug.shouldSkip.LinuxCondition;
import com.debug.shouldSkip.WindowCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/15 16:40
 **/
@Configuration
public class MyConfig {

    @Bean("config1")
    @Autowired()
    public String bean01(@Value("person") Person person) {
        System.out.println(person.toString());
        return "Test skip：这是Window OS";
    }

    @Bean("config2")
    public String bean02() {
        return "Test skip：这是 Linux OS";
    }

    @Bean("config3")
    public String bean03(@Value("${person.name}") String name) {
        System.out.println(name);
        return "Test skip：这是 Window OS 3.0";
    }


}
