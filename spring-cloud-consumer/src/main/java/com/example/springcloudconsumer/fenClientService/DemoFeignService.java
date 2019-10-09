package com.example.springcloudconsumer.fenClientService;/*
 * @author p78o2
 * @date 2019/9/5
 */

import com.example.api.service.TestService;
import com.example.springcloudconsumer.fenClientService.impl.DemoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;

// name: 服务者application.yml中的spring.application.name
// fallback: 断路器执行方法，即方法执行失败调用
@FeignClient(name="demo-provider", fallback = DemoServiceFallback.class)
public interface DemoFeignService extends TestService {
//    断路器
}
