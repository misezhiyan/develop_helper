package com.kimmy.learn.web;

import com.kimmy.learn.web.test.TestService;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class TemplateTests {

    @Autowired
    TestService testService;

    @Test
    public void test() throws IOException, TemplateException {
        testService.testFreemarker();
    }

}
