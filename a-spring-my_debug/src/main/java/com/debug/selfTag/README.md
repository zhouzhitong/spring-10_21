

# 扩展：

## 1、 自定义标签



- `什么是标签？`

> 1、在 Spring 中标签分为 **默认标签**，和**自定义标签**。



- **标签的分类：**

> 1. 默认标签 `<bean ..>..</>`
> 2. 自定义标签：例如：`<context:property-placeholder></>`



- `标签解析过程：`

```shell
- 1、每个`标签`都存在对应的 `命名空间`
- 2、所有的`命名空间`，都存放在：`META-INF/spring.handlers`文件目录下
- 3、然后根据`命名空间`，找到对应的'NamespaceHandler'处理器。
- 4、通过反射实例化`NamespaceHandler`处理器，并通过调用`init()方法`，添加'BeanDefinitionParser'解析器
- 5、'NamespaceHandler'处理器最后调用`parse()`方法开始进行解析标签。(找到对应的'Parser',进行解析)
```



**简单明了：**

标签信息（包含`命名空间`）

--> 在`META-INF/spring.handlers`找到对应的`NamespaceHandler`处理器

--> 找到对应的`BeanDefinitionParser`解析器 

--> 开始解析标签，并将解析后的对象进行注册到容器中。





- **使用案例**

涉及的接口或类：

> 1、`org.springframework.beans.factory.xml.NamespaceHandlerSupport`
>
> 2、`org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser`



涉及的文件：

> 1、`META-INF/spring.handlers`
>
> 2、`META-INF/spring.schemas`
>
> 3、`**.xsd`



#### 第一步：准备好`Bean`对象和`BeanDefinitionParser`实现子类

```java
public class UserTag {
    private String name;
    private String username;
    private String password;
    //... setter、getter
}
public class UserTagBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return UserTag.class;
    }
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        String username = element.getAttribute("username");
        String password = element.getAttribute("password");
        if (StringUtils.hasText(name)) {
            builder.addPropertyValue("name", name);
        }
        if (StringUtils.hasText(username)) {
            builder.addPropertyValue("username", username);
        }
        if (StringUtils.hasText(password)) {
            builder.addPropertyValue("password", password);
        }
    }
}
```


#### 第二步：准备`NamespaceHandlerSupport`

```java
public class UserTagNamespaceHandler extends NamespaceHandlerSupport  {
    @Override
    public void init() {
        // TODO “user” 是用来匹配，标签名的
        registerBeanDefinitionParser("user", new UserTagBeanDefinitionParser());
    }
}
```



#### 第三步：准备自己的`.xsd`文件

`userTag.xsd`
```xml
<?xml version="1.0" encoding="UTF-8"?>

<schema xmlns="http://www.w3.org/2001/XMLSchema"
        targetNamespace="http://www.mashibing.com/schema/userTag"
        elementFormDefault="qualified">
    <element name="user"> <!-- 标签名字 -->
        <complexType>
            <attribute name="id" type="string" default="zs"/><!-- 根据 id 获取bean -->
            <attribute name="name" type="string" default="zhangsan"/>
            <attribute name="username" type="string" default="root"/>
            <attribute name="password" type="string" default="root@hiekn"/>
        </complexType>
    </element>
</schema>
```



#### 第四步：准备好`spring.handlers`和`spring.schemas`

```properties
# spring.handlers 下面的 http 与 上面的 xsd文件中的 targetNamespace 对应
http\://www.mashibing.com/schema/userTag=com.debug.selfTag.UserTagNamespaceHandler

# spring.schemas
http\://www.mashibing.com/schema/userTag.xsd=META-INF/userTag.xsd

```



#### 第五步：准备案例

`beans.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:myTag="http://www.mashibing.com/schema/userTag"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.mashibing.com/schema/userTag
       http://www.mashibing.com/schema/userTag.xsd">
    <myTag:user id="user"/>
</beans>
```



`Demo01.java`

```java
public class Demo01 {

    public static void main(String[] args) {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("selfTagBeans.xml"); 
        UserTag user = ac.getBean("user", UserTag.class);
        System.out.println(user);
    }
}
```



