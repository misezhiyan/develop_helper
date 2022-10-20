package com.kimmy.learn.web.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;


    /**
     * 测试链接
     * @param request
     * @return
     */
    @RequestMapping("/test")
    public TestResponse test(@RequestBody TestRequest request) {

        System.out.println(JSON.toJSONString(request));

        // return  testService.testDbConnect();
        return TestResponse.success();
    }

}
