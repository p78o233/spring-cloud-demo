package com.example.gateway.config;/*
 * @author p78o2
 * @date 2019/10/12
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import reactor.core.publisher.Mono;

import javax.xml.validation.Validator;
import java.util.List;

@Configuration
public class ExampleConfiguration {
//    全局过滤器
    @Bean
//    这个是过滤器顺序，越小越后，没有order的最先执行
    @Order(1)
    public GlobalFilter firstTestFilter(){
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                System.out.println("第一个过滤器");
            }));
        };
    }
    //    全局过滤器
    @Bean
//    这个是过滤器顺序，越小越后，没有order的最先执行
    @Order(0)
    public GlobalFilter secondTestFilter(){
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                System.out.println("第二个过滤器");
            }));
        };
    }

}
