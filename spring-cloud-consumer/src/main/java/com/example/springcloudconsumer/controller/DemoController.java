package com.example.springcloudconsumer.controller;/*
 * @author p78o2
 * @date 2019/9/5
 */

import com.example.api.service.TestService;
import com.example.springcloudconsumer.fenClientService.DemoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cloud")
public class DemoController {
    @Autowired
    private DemoFeignService testService;
    private static int i = 0;
    @RequestMapping("/test")
    public String test() {
        System.out.println(i++);
        return testService.getTest("test");
    }

}
