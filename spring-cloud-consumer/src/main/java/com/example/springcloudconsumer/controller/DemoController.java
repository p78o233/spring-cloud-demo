package com.example.springcloudconsumer.controller;/*
 * @author p78o2
 * @date 2019/9/5
 */

import com.example.api.service.TestService;
import com.example.springcloudconsumer.fenClientService.DemoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/cloud")
public class DemoController {
    @Autowired
    private DemoFeignService testService;
    @Autowired
    private KafkaTemplate<String, String> template;
    private static int i = 0;
//    测试接口
    @GetMapping("/test")
    public String test() throws InterruptedException{
        System.out.println(i++);
        return testService.getTest("test");
    }
//    超时熔断接口
    @GetMapping ("/overTime")
    public Object test3() {
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "dbToEs";
    }
//    kafka接口
    @GetMapping("/sendMsg/{msg}")
    public void sendMsg(@PathVariable("msg")String msg){
        this.template.send("test", msg);
    }

}
