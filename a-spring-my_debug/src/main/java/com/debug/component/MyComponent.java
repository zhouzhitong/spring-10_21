package com.debug.component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/15 16:39
 **/
@Component
@ComponentScan(value = {"com.debug.config", "com.debug.shouldSkip"})
public class MyComponent {
}
