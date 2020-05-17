package com.rock.customer;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class FeignInterceptorConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            System.out.println("template = " + template);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();
                if (headerNames != null) {
                    String headerName;
                    String headerValue;
                    while(headerNames.hasMoreElements()) {
                        headerName = headerNames.nextElement();
                        System.out.println("headerValue = " + headerName);
                    }
                }
            }

        };
    }
}

