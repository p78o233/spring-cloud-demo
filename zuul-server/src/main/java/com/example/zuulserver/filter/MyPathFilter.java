package com.example.zuulserver.filter;/*
 * @author p78o2
 * @date 2019/11/4
 */
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Configuration
public class MyPathFilter {
    @Bean

    public RemoteIpFilter remoteIpFilter() {

        return new RemoteIpFilter();

    }



    @Bean

    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(new MyFilter());//添加过滤器

        registration.addUrlPatterns("/*");//设置过滤路径，/*所有路径

        registration.addInitParameter("name", "alue");//添加默认参数

        registration.setName("MyFilter");//设置优先级

        registration.setOrder(1);//设置优先级

        return registration;

    }
    public class MyFilter implements Filter{
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse) res;

            HttpServletRequest reqs = (HttpServletRequest) req;
            System.out.println("getRequestURI:          -----"+reqs.getRequestURI());
            System.out.println("token:          -----"+reqs.getHeader("token"));
//        根据token查询用户权限
            chain.doFilter(req, res);
        }
        public void init(FilterConfig filterConfig) {}
        public void destroy() {}
    }

}
