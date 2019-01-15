package com.alanagou.springcloud.controller;

import com.alanagou.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alanagou
 * @Title: HelloController
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201915:17
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("en")
    public String he(){
        return helloService.go();
    }
}
