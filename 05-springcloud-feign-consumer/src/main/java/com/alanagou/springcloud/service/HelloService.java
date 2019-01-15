package com.alanagou.springcloud.service;

import com.alanagou.springcloud.fallback.MyFallback;
import com.alanagou.springcloud.fallback.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author alanagou
 * @Title: HelloService
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201915:10
 */
@FeignClient(name="02-springcloud-provider",/*fallback = MyFallback.class*/fallbackFactory = MyFallbackFactory.class)
public interface HelloService {
    @RequestMapping("service/hello")
    public String go();
}
