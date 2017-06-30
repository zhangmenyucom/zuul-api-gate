package com.taylor.app;

import com.netflix.zuul.FilterProcessor;
import com.taylor.errorattributes.ZuulErrorAttributes;
import com.taylor.filterprocessor.ZuulFilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by haoli on 2017/4/2
 */
@SpringBootApplication(scanBasePackages = "com.taylor")
@EnableZuulProxy
public class GateApplication {
    public static void main(String... args) throws Exception {
        SpringApplication.run(GateApplication.class, args);
        FilterProcessor.setProcessor(new ZuulFilterProcessor());
    }

    @Bean
    public DefaultErrorAttributes errorAttributes() {
        return new ZuulErrorAttributes();
    }

    /**
     * 动态刷新路由规则
     **/
    @Bean
    @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }
}
