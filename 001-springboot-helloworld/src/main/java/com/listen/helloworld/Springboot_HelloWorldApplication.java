package com.listen.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* @SpringBootApplication来标注一个主程序类，说明这是一个Spring Boot应用
*   Spring Boot应用标注在某个类上说明这个类是SpringBoot的主配置类，
*   SpringBoot就应该运行这个类的main方法来启动SpringBoot应用
*
* @SpringBootApplication注解的详细信息：
* @Target({ElementType.TYPE})
* @Retention(RetentionPolicy.RUNTIME)
* @Documented
* @Inherited
* @SpringBootConfiguration
* @EnableAutoConfiguration
* @ComponentScan(
*   excludeFilters = {@Filter(
*   type = FilterType.CUSTOM,
*   classes = {TypeExcludeFilter.class}
* ), @Filter(
*   type = FilterType.CUSTOM,
*   classes = {AutoConfigurationExcludeFilter.class}
* )}
* )
* public @interface SpringBootApplication {
*
* 注解层次说明：（每一级注解的下一级注解都是那一级注解的注解）
* @SpringBootApplication标注在某个类上表明该类是Spring Boot的配置类：
*   @SpringBootConfiguration：
*       @Configuration，在配置类上标注的注解，属于Spring的注解
*       配置类作用和配置文件差不多；
*           @Component：表明配置类也是容器中的一个组件
*   @EnableAutoConfiguration：开启自动配置功能，以前需要我们配置的东西，Spring Boot帮我们自动配置；
*       这个注解告诉SpringBoot开启自动配置功能，这样自动配置才能生效
*       @AutoConfigurationPackage：自动配置包
*           @Import({Registrar.class})：
*           Spring的底层注解@Import，给容器中导入一个组件Registrar.class
*           这个组件的作用：将主配置类（@SpringBootApplication标注的类）的所在包及下面所有子包里面的所有组件扫描到Spring容器
*       @Import({AutoConfigurationImportSelector.class})：
*       给容器中导入AutoConfigurationImportSelector.class的组件
*       这个组件的作用：将所有需要导入的组件以全类名的方式返回；这些组件就会被添加到容器中；
*       这个组件中的getAutoConfigurationEntry()方法会给容器中导入非常多的自动配置类（xxxAutoConfiguration）；就是给容器中导入这个场景需要的所有组件，并配置好这些组件
*       有了自动配置类，就免去了我们手动编写配置注入功能组件等工作
*           SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, classLoader);
*       SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中，自动配置类就失效，帮我们进行自动配置工作；以前我们需要自己配置的东西，自动配置类都帮我们做了
*       J2EE的整体整合解决方案和自动配置都在spring-boot-autoconfigure-2.3.1.RELEASE.jar里面
*
*
*
*/
@SpringBootApplication
public class Springboot_HelloWorldApplication {

    public static void main(String[] args) {
        //启动SpringBoot
        SpringApplication.run(Springboot_HelloWorldApplication.class, args);
    }
}
