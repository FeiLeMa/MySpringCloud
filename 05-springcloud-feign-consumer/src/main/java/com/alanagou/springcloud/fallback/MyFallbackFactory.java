package com.alanagou.springcloud.fallback;

import com.alanagou.springcloud.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author alanagou
 * @Title: MyFallbackFactory
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201915:46
 */
@Component
public class MyFallbackFactory implements FallbackFactory<HelloService> {
    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String go() {
                return throwable.getMessage();
            }
        };
    }
}
