package com.listen.Springboot_Config;

import com.listen.Springboot_Config.bean.Dog;
import com.listen.Springboot_Config.bean.Person;
import com.listen.Springboot_Config.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/*
 * SpringBoot的单元测试：
 * 可以在测试期间很方便的类似编码一样进行自动注入的功能
 */
@SpringBootTest
class ApplicationTests {
    @Autowired
    Person person;
    @Autowired
    Dog dog;
    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        //可以发现.yaml和.properties两个配置文件都生效了
        //相同属性以properties文件为准，如果properties文件没有配置，yaml配置了，则以yaml文件为准
        //测试加载顺序为：（后加载的属性会把之前加载的属性覆盖掉）
        //自定义.properties --> application.yaml --> application.properties
        System.out.println(person);
        System.out.println(dog);
    }

    @Test
    void testHelloService() {
        boolean isHas1 = ioc.containsBean("helloService");
        boolean isHas2 = ioc.containsBean("helloService2");
        //未加@ImportResource注解时为false，说明SpringBoot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别。
        System.out.println("has helloService ? "+isHas1);
        System.out.println("has helloService2 ? "+isHas2);
        /*
        * SpringBoot推荐使用【全注解】的方式给容器中添加组件：
        *   1.写一个配置类，相当于Spring的配置文件
        *   2.使用@Bean给容器中添加组件，方法名为给容器中添加的bean的id名
        */
    }

}
