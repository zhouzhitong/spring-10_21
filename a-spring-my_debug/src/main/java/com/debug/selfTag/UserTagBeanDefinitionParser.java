package com.debug.selfTag;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/15 9:59
 **/
public class UserTagBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return UserTag.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
//        UserTag userTag = new UserTag();
        String name = element.getAttribute("name");
        String username = element.getAttribute("username");
        String password = element.getAttribute("password");
        if (StringUtils.hasText(name)) {
            builder.addPropertyValue("name", name);
//            userTag.setName(name);
        }
        if (StringUtils.hasText(username)) {
            builder.addPropertyValue("username", username);
//            userTag.setUsername(username);
        }
        if (StringUtils.hasText(password)) {
            builder.addPropertyValue("password", password);
//            userTag.setPassword(password);
        }
//        builder.addPropertyValue("zzt", userTag);
    }

    /*@Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UserTag.class);
        UserTag userTag = new UserTag();
        String name = element.getAttribute("name");
        String username = element.getAttribute("username");
        String password = element.getAttribute("password");
        if (StringUtils.hasText(name)) {
            userTag.setName(name);
        }
        if (StringUtils.hasText(username)) {
            userTag.setUsername(username);
        }
        if (StringUtils.hasText(password)) {
            userTag.setPassword(password);
        }
        builder.addPropertyValue("zzt", userTag);
        return builder.getBeanDefinition();
    }*/

}
