package com.debug.shouldSkip;

import com.debug.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/15 21:25
 **/
@Configuration
@Conditional(WindowCondition.class)
@PropertySource({"classpath:db.properties"})
public class MyConditional {


    @Bean("skip1")
    @Autowired()
    @Conditional(WindowCondition.class)
    public String bean01(@Value("person") Person person) {
        System.out.println(person.toString());
        return "Test skip：这是Window OS";
    }

    @Bean("skip2")
    @Conditional(LinuxCondition.class)
    public String bean02() {
        return "Test skip：这是 Linux OS";
    }

    @Bean("skip3")
    @Conditional(WindowCondition.class)
    public String bean03(@Value("${person.name}") String name) {
        System.out.println(name);
        return "Test skip：这是 Window OS 3.0";
    }

}
