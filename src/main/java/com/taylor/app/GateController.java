package com.taylor.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by haoli on 2017/4/2
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class GateController {
    public static void main(String... args) throws Exception {
        SpringApplication.run(GateController.class, args);
    }
}
