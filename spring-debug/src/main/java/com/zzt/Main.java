package com.zzt;

import com.zzt.context.MyClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/9 20:57
 **/
public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = new MyClassPathXmlApplicationContext("/selfApplicationContext.xml");
    }

}
