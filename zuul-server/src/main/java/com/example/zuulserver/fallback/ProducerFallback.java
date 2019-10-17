package com.example.zuulserver.fallback;/*
 * @author p78o2
 * @date 2019/10/17
 */

import com.alibaba.fastjson.JSON;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
//自定义熔断处理
@Component
public class ProducerFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        return "demo-customer";
    }

    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                Map<String,Object> map = new HashMap<>();
                map.put("code",502);
                map.put("message","链接超时，请稍后重试");
                return new ByteArrayInputStream(JSON.toJSONString(map).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }


    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if (cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
        }
        return fallbackResponse();
    }
}
