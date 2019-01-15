package com.alanagou.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alanagou
 * @Title: GateWayController
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201922:00
 */
@RestController
public class GateWayController {
    @RequestMapping("/api/local")
    public String hello() {
        int a = 3/0;
        return "exec the api gateway.";
    }
}
