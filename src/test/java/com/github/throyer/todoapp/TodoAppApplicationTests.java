package com.github.throyer.todoapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoAppApplicationTests {
    @BeforeAll
    public static void disableHeadless() {
        System.setProperty("java.awt.headless", "false");
    }

    @Test
    void contextLoads() { }
}
