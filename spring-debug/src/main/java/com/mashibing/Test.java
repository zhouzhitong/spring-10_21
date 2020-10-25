package com.mashibing;

import com.mashibing.bean.Person;
import com.mashibing.context.MyClassPathXmlApplicationContext;
import com.mashibing.selfEditor.Customer;
import com.mashibing.selftag.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
//        MyClassPathXmlApplicationContext ac = new MyClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-${username}.xml");
//        Person bean = ac.getBean(Person.class);
//        System.out.println(bean);
//        A bean1 = ac.getBean(A.class);
//        System.out.println(bean1);
//        ac.close();
//        User user = (User) ac.getBean("msb");
//        System.out.println(user.getUsername());
        test01();
//        test02();
//        test03();

    }

    private static void test01() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
        User user = ac.getBean("msb", User.class);
        System.out.println(user);
    }

    private static void test02() {
        MyClassPathXmlApplicationContext ac = new MyClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);

    }

    private static void test03(){
        MyClassPathXmlApplicationContext ac = new MyClassPathXmlApplicationContext("/applicationContext.xml");
//        MyClassPathXmlApplicationContext ac = new MyClassPathXmlApplicationContext("selfEditor.xml");
        Customer bean = ac.getBean(Customer.class);
        System.out.println(bean);
    }
}
