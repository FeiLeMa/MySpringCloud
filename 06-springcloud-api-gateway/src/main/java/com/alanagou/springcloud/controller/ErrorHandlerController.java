package com.alanagou.springcloud.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alanagou
 * @Title: ErrorHandleController
 * @ProjectName 01-springcloud-eureka-server
 * @Description: TODO
 * @date 10/01/201922:26
 */
@RestController
public class ErrorHandlerController implements ErrorController {
    /**
     * 出异常后进入该方法，交由下面的方法处理
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("/error")
    public Object error(){
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulException exception = (ZuulException)ctx.getThrowable();
        return exception.nStatusCode + "--" + exception.getMessage();
    }
}
