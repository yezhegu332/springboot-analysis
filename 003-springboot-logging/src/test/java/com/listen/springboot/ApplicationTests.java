package com.listen.springboot;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
* 如何让系统中所有的日志都统一到slf4j；
* 1、将系统中其他日志框架先排除出去；
* 2、用中间包来替换原有的日志框架；
* 3、我们导入slf4j其他的实现
*/
@SpringBootTest
class ApplicationTests {
    //记录器
    Log logger = LogFactory.getLog(getClass());
    @Test
    void contextLoads() {
        //日志的级别：
        //由低到高：
        //可以调整输出的日志级别，日志就只会在这个级别及以后的高级别生效
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        //SpringBoot默认给我们使用的是info级别的。我们没有指定级别的话，SpringBoot就使用默认规定的级别--root级别
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");

    }

}
