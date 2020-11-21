package com.debug.listener;

import org.springframework.context.ApplicationListener;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/19 11:11
 **/
public class MyApplicationListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
    }

}
