package com.alanagou.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alanagou
 * @Title: ConfigController
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 15/01/201912:34
 */
@RestController
public class ConfigController {

    @Value("${url}")
    private String url;

    @RequestMapping("/cloud/url")
    public String url(){
        return url;
    }

}
