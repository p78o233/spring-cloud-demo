package com.example.srpingcloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SrpingCloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrpingCloudProviderApplication.class, args);
    }

}
