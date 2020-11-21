package com.debug.listener;

import org.springframework.context.ApplicationEvent;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/19 11:12
 **/
public class MyEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }



}
