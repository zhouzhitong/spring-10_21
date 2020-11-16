package com.zzt.scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/9 21:27
 **/
@Configuration
public class MyScanService {

    @Bean
    public String show(){
        return "msb";
    }

}
