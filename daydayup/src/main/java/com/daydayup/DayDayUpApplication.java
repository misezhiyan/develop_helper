package com.daydayup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DayDayUpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DayDayUpApplication.class, args);
        System.out.println("http://localhost:" + context.getEnvironment().getProperty("server.port") + context.getEnvironment().getProperty("server.servlet.context-path"));
    }

}
