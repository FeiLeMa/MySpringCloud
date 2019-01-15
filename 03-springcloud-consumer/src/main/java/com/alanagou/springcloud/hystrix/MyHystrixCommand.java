package com.alanagou.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author alanagou
 * @Title: MyHystrixCommand
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201911:42
 */
public class MyHystrixCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;
    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        //调用远程服务
        return restTemplate.getForObject("http://02-springcloud-provider/service/hystrix", String.class);
    }
    @Override
    public String getFallback(){
        return "服务降级处理方法";
    }

}
