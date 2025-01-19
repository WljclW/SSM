package com.example.springboot01demo;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
public class LoggingTest {

    @Test
    void test01(){
        //如果没有使用@Slf4j注解可以使用下面的方法来记录日志
        //1.获取一个日志记录器
        Logger logger = LoggerFactory.getLogger(LoggingTest.class);
        //2.记录日志
        logger.trace("追踪日志trace.....");
        logger.debug("调试日志debug.....");
        logger.info("信息日志info.....");
        logger.warn("警告日志warn.....");
        logger.error("错误日志error.....");
    }

    /**
     * 日志级别，由低到高：all < trace < debug < info < warn < error < off。
     * 日志级别越高，表示打印的越粗糙（打印的信息越少）：比如error就是出错了才打印，debug还会打印调试以及info的信息
     * 日志有一个默认级别（info），默认值会打印该级别 以及 该级别之上级别 的日志信息
     * 日志默认级别在.properties文件中修改。比如：logging.level.root=debug表示修改项目根(root)的日志级别为debug
     * */
    @Test   //以后就是下面这样使用
    void test02(){      //需要配合@Slf4j注解使用
        /**
         * 如果使用@Slf4j注解，则容器中就会自动注入一个log对象，然后直接使用log对象来调用对应的日志方法 记录对应类型的日志
         * */
        log.trace("追踪日志trace.....");
        log.debug("调试日志debug.....");
        log.info("信息日志info.....");
        log.warn("警告日志warn.....");
        log.error("错误日志error.....");
    }
}
