package com.listen.Springboot_Config.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 李松
 * 2020/7/20
 */
/*
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *   prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
 * 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能；所以还需要加上@Component
 * @ConfigurationProperties(prefix = "person")默认从全局配置文件中获取值
 *
 * @ConfigurationProperties和@Value两个注解可以一起使用
 *  如果属性上有@Value，则以@Value为准，如果没有，则以配置文件设置的属性值为准
 */

/*
 * @ConfigurationProperties和@Value的区别：
 * ------------------------------------------------------------------
 *                    |   @ConfigurationProperties  |    @Value
 * -------------------|-----------------------------|----------------
 * 功能               |  批量注入配置文件中的属性      |   一个个指定
 * 松散绑定（松散语法） |  支持                        |   不支持
 * SpEL               |  不支持                      |   支持
 * JSR303数据校验      |  支持                        |   不支持
 * 复杂类型封装        |  支持                        |   不支持
 * -------------------------------------------------------------------
 * 如果我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；
 * 如果我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；
 */
//@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
//@Validated  //JSR303数据校验
public class Person {
    /*
     * <bean class="Person">
     *      <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{spEL}"/>
     * </bean>
     */
//    @Value("${person.last-name}")
//    @Email  //验证lastName必须是邮箱格式，使用@ConfigurationProperties可以生效，使用@Value不能生效
    private String lastName;
//    @Value("#{11*2}")
    private Integer age;
//    @Value("true")
    private boolean boss;
    private Date birth;
//    @Value("${person.maps}")  //如果不用@ConfigurationProperties只用@Value，那么会报错
    private Map<String, Object> maps;
//    @Value("${person.lists}")   //这里@Value可以获取到List的值
    private List<Object> lists;
    private Dog dog;

    public Person() {
    }

    public Person(String lastName, Integer age, boolean boss, Date birth, Map<String, Object> maps, List<Object> lists, Dog dog) {
        this.lastName = lastName;
        this.age = age;
        this.boss = boss;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
