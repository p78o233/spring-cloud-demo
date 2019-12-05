package com.example.zuulserver.interceptor;/*
 * @author p78o2
 * @date 2019/11/5
 */

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
//网关式过滤器，可以返回
public class ParamInterceptor extends ZuulFilter {
    @Override
    public String filterType() {
//        return "pre";
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
//        if(request.getHeader("token")==null){
//            ctx.setSendZuulResponse(false);//不转发至后续服务器
//            JSONObject json = new JSONObject();
//            json.put("ret",false);
//            json.put("code",401);
//            json.put("data","token不能为空");
//            json.put("message","");
//            ctx.setResponseBody(JSONObject.toJSONString(json));
//            ctx.getResponse().setContentType("text/html;charset=UTF-8");
//            System.out.println(3);
//            return null;
//        }else{
//
//        }
        return null;
    }
}
