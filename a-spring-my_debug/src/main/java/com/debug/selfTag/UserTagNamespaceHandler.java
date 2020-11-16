package com.debug.selfTag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/15 9:57
 **/
public class UserTagNamespaceHandler extends NamespaceHandlerSupport  {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserTagBeanDefinitionParser());
    }
}
