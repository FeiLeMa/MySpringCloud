package com.alanagou.springcloud.fallback;

import com.alanagou.springcloud.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author alanagou
 * @Title: MyFallback
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201915:33
 */
@Component
public class MyFallback implements HelloService {
    @Override
    public String go() {
        return "服务异常";
    }
}
