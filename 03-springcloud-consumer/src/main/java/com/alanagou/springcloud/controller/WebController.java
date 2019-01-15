package com.alanagou.springcloud.controller;

import com.alanagou.springcloud.hystrix.MyHystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author alanagou
 * @Title: WebController
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201909:14
 */
@RestController
public class WebController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("index")
    public String index(){
       return restTemplate.getForObject("http://02-springcloud-provider/service/hello", String.class);
    }

    @HystrixCommand(fallbackMethod="error",commandProperties={ @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",
            value="2000")})
    @RequestMapping("hystrix")
    public String hystrix(){
        int a = 3/0;
        return restTemplate.getForObject("http://02-springcloud-provider/service/hystrix", String.class);
    }

    public String error(Throwable throwable){
        return throwable.getMessage();
    }

    @RequestMapping("yourHystrix")
    public String yourHystrix() throws ExecutionException, InterruptedException {
        MyHystrixCommand myHystrixCommand = new MyHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),restTemplate);
        //同步方法
//        String str = myHystrixCommand.execute();
        //异步调用,开启一条线程
        Future<String> future = myHystrixCommand.queue();
//        业务逻辑
        String str = future.get();
        return str;
    }
}

