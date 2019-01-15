package com.alanagou.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author alanagou
 * @Title: BaseConfig
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201909:16
 */
@Configuration
public class BeanConfig {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
