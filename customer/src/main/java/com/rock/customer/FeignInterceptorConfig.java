package com.rock.customer;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class FeignInterceptorConfig {
    @Bean("feignInterceptor")
    public RequestInterceptor getRequestInterceptor(){
        return new FeignInterceptor();
    }
    class FeignInterceptor implements RequestInterceptor{

        @Override
        public void apply(RequestTemplate requestTemplate) {
            System.out.println("   Feign  Interceptor ");
            ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder
                    .getRequestAttributes();
            if(attributes == null){
                return;
            }
            HttpServletRequest request = attributes.getRequest();
            Map<String, String[]> parameterMap = request.getParameterMap();
            parameterMap.keySet().forEach(v-> {
                System.out.println("parameterMap = " + parameterMap.get(v));
            });
        }
    }
}

