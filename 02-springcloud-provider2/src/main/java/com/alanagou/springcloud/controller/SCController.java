package com.alanagou.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alanagou
 * @Title: SCController
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201909:07
 */
@RestController
public class SCController {

    @RequestMapping("service/hello")
    public String hello(){
        return "你妈了个臭逼2";
    }
    @RequestMapping("service/hystrix")
    public String hystrix(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我设置了超市2";
    }
}
