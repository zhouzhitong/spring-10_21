package com.debug.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/19 20:39
 **/
public class MyBeanFactory implements BeanFactoryAware {



    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
