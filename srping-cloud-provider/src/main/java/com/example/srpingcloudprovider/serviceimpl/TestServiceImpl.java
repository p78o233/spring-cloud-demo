package com.example.srpingcloudprovider.serviceimpl;/*
 * @author p78o2
 * @date 2019/9/5
 */

import com.example.api.service.TestService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
public class TestServiceImpl implements TestService {
    private final CountDownLatch latch = new CountDownLatch(3);
    @Override
    public String getTest(String testName) {
        return testName+":233";
    }

    @Override
    public String getTestRibbon() {
        return "ABC";
    }

    @Override
    public String getOverTime() {
        return null;
    }
    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<String, String> cr) throws Exception {
        System.out.println("我是消费者:"+cr.toString());
        latch.countDown();
    }
}
