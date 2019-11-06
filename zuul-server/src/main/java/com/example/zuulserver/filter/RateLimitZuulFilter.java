package com.example.zuulserver.filter;/*
 * @author p78o2
 * @date 2019/10/17
 */


import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//过滤器限流
@Component
public class RateLimitZuulFilter extends ZuulFilter {
    //每秒创建100个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);
    /**
     * 设置过滤器类型
     *
     * @return String
     */
    @Override
    public String filterType() {
        //设置为前置过滤器
//        return "pre";
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器顺序：值越小，越先执行
     *
     * @return int
     */
    @Override
    public int filterOrder() {
        return -1;
    }

    /**
     * 过滤是否生效
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = requestContext.getRequest();
//        //对订单接口进行限流
//        return "/order/api/order/save".equalsIgnoreCase(request.getRequestURI());
       return true;
    }

    /**
     * shouldFilter返回True则执行此方法，用于写业务逻辑
     *
     * @return Object
     * @throws ZuulException 异常
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //非阻塞式获取令牌
        if (!RATE_LIMITER.tryAcquire()) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        return null;
    }

}
