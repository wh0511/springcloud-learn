package com.wh.learn.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {


    //两种方式调用其他服务或者说接口
    //方式1,基于httpClient的 restTemplate
    //方式2,基于springCloud的 fegin

    //方式1
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    public String getOrder(){
        //方式1 直接写目标服务地址的方式调用
        //String forObject = restTemplate.getForObject("http://127.0.0.1:8000/getMember", String.class);
        //方式2 通过别名访问,注意,使用别名的方式,必须在restTemplate生成的时候加上一个注解 LoadBalanced
        //目的是,使用ribbon,达到客户端负载均衡的能力
        String url = "http://wh-learn-member:8000/getMember";
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println("结果是:" + forObject);
        return forObject;
    }
}
