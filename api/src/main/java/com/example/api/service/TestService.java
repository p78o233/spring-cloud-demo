package com.example.api.service;/*
 * @author p78o2
 * @date 2019/9/5
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface TestService {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String getTest(@RequestParam("testName")String testName);
    @RequestMapping(value = "/testRibbon",method = RequestMethod.GET)
    public String getTestRibbon();
}
