package com.mrkloklo.weblog.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class WeblogWebApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testLog(){
        log.info("这是一行 info 级别的日志");
        log.warn("这是一行 warn 级别的日志");
        log.error("这是一行 error级别的日志");

        String author = "mrkloklok";
        log.info("这是一行带有占位符日志，作者：{}",author);
    }

}
