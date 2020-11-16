package com.debug;

import com.debug.bean.Person;
import com.debug.bean.PersonInfo;
import com.debug.selftEditor.Address;
import com.debug.selftEditor.Customer;
import com.debug.context.MyClassPathXmlApplicationContext;
import com.debug.selfTag.UserTag;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/14 23:47
 **/
public class DebugDemo01 {

    public static void main(String[] args) {
//        beansTest();
//        selfTagTest();
        selfEditorTest();
    }

    private static void selfEditorTest() {
        ApplicationContext ac = new MyClassPathXmlApplicationContext("selfBfppBeans.xml");
        Customer customer = ac.getBean("customer", Customer.class);
        System.out.println(customer);
        Address address = ac.getBean(Address.class);
        System.out.println(address);
    }

    private static void selfTagTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("selfTagBeans.xml");
        UserTag user = ac.getBean("user", UserTag.class);
        System.out.println(user);
    }

    private static void beansTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/beans.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
        PersonInfo personInfo = ac.getBean("personInfo", PersonInfo.class);
        System.out.println(personInfo);
    }

}
