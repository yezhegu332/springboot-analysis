package com.listen.Springboot_Config.config;

import com.listen.Springboot_Config.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Listen
 * @Date: 2020/7/20
 */
/*
* @Configuration：指明当前类是一个配置类，用来替代之前的Spring的配置文件
* 在配置文件中用<bean></bean>标签添加组件
*/
@Configuration
public class MyAppConfig {
    //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService2(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }
}
