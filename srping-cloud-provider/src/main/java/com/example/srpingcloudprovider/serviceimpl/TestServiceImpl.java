package com.example.srpingcloudprovider.serviceimpl;/*
 * @author p78o2
 * @date 2019/9/5
 */

import com.example.api.service.TestService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServiceImpl implements TestService {
    @Override
    public String getTest(String testName) {
        return testName+":233";
    }

    @Override
    public String getTestRibbon() {
        return "ABC";
    }
}
