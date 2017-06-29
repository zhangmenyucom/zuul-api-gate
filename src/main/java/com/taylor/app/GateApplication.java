package com.taylor.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by haoli on 2017/4/2
 */
@SpringBootApplication(scanBasePackages = "com.taylor")
@EnableZuulProxy
public class GateApplication {
    public static void main(String... args) throws Exception {
        SpringApplication.run(GateApplication.class, args);
    }


}
