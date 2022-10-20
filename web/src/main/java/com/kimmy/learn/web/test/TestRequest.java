package com.kimmy.learn.web.test;

import org.springframework.stereotype.Component;

@Component
public class TestRequest {

    private String test;

    private Integer testInt;


    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Integer getTestInt() {
        return testInt;
    }

    public void setTestInt(Integer testInt) {
        this.testInt = testInt;
    }
}
