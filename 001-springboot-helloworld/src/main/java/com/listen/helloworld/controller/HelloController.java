package com.listen.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 李松
 * 2020/7/18
 */
//这个类的所有方法返回的数据直接写给浏览器，（如果是对象，可以转为json数据）
/*@ResponseBody
@Controller*/
@RestController //这个注解可以替换上述两个注解
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello @RestController";
    }
}

/*
* resources文件夹中的目录结构：
*   static：保存所有的静态资源；js css images等；
*   templates：保存所有的模板页面；（SpringBoot默认jar包使用嵌入式的Tomcat，默认不支持JSP页面）
*              可以使用模板引擎（freemarker，thymeleaf）
*   application.properties：Spring Boot应用的配置文件，可以修改一些默认设置
*/

