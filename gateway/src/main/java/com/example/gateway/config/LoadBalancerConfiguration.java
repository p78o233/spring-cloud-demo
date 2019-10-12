package com.example.gateway.config;/*
 * @author p78o2
 * @date 2019/10/12
 */

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.gateway.filter.LoadBalancerClientFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalancerConfiguration {
    /**
     * 自定义负载均衡过滤器
     *
     * @param client     LoadBalancerClient
     * @param properties LoadBalancerProperties
     * @return CustomLoadBalancerClientFilter
     */
    @Bean
    public LoadBalancerClientFilter customLoadBalancerClientFilter(LoadBalancerClient client,
                                                                   LoadBalancerProperties properties) {
        return new CustomLoadBalancerClientFilter(client, properties);
    }
    /**
     * 自定义负载均衡规则
     *
     * @return CustomLoadBalancerRule
     */
    @Bean
    public IRule customLoadBalancerRule() {
        return new CustomLoadBalancerRule();
    }
}
