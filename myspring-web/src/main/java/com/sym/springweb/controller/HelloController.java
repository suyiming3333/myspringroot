package com.sym.springweb.controller;

import com.sym.springweb.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * scope:
 * singleton:   一个bean的 作用域设置为singleton, 那么Spring IOC容器中只会
 *              存在一个共享的bean实例，并且所有对bean的请求
 * prototype:   每一次请求（将其注入到另一个bean中，或者以程序的方式调用容器的
 *              getBean()方法）都会产生一个新的bean实例
 * request:     针对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP request
 *              内有效(request、session、global session使用的时候首先要在初始化web的web.xml中做如下配置)
 * session:     该针对每一次HTTP请求都会产生一个新的bean，同时该bean仅在当前HTTP session内有效
 * global session
 */
@Scope("singleton")
@Controller
@RequestMapping("/helloController")
public class HelloController {

    @Autowired
    private HelloService helloService;


    @RequestMapping(value = "/sayHello")
    @ResponseBody
    public String sayHello(){
        helloService.sayHello();
        return "hello";
    }
}
