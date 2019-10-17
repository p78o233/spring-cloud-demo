package com.example.gateway.controller;/*
 * @author p78o2
 * @date 2019/10/16
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//熔断处理类
public class FallbackController {
    @GetMapping("/defaultfallback")
    public Map defaultFallback() {
        Map map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "服务异常");
        return map;
    }
}