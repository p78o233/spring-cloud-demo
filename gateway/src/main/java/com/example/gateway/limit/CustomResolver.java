package com.example.gateway.limit;/*
 * @author p78o2
 * @date 2019/10/14
 */

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class CustomResolver {
    @Bean
    public KeyResolver ipKeyResolver(){
        System.out.println("##############ipKeyResolver########################");
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}