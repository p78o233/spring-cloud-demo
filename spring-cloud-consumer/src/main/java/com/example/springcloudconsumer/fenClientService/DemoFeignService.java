package com.example.springcloudconsumer.fenClientService;/*
 * @author p78o2
 * @date 2019/9/5
 */

import com.example.api.service.TestService;
import com.example.springcloudconsumer.fenClientService.impl.DemoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="demo-provider", fallback = DemoServiceFallback.class)
public interface DemoFeignService extends TestService {

}
