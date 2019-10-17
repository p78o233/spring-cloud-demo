package com.example.springcloudconsumer.fenClientService.impl;/*
 * @author p78o2
 * @date 2019/9/5
 */

import com.example.springcloudconsumer.fenClientService.DemoFeignService;
import org.springframework.stereotype.Component;
//断路器的实现
@Component
public class DemoServiceFallback implements DemoFeignService {

    @Override
    public String getTest(String testName) {
        return "error";
    }

    @Override
    public String getTestRibbon() {
        return null;
    }

    @Override
    public String getOverTime() {
        return null;
    }
}
