package com.kimmy.learn.web;

import com.kimmy.learn.web.test.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DbTests {

    @Autowired
    TestService testService;

    @Test
    public void test() {
        testService.testDbConnect();
    }

}
