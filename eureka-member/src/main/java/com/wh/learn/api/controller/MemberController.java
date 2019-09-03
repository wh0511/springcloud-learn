package com.wh.learn.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MemberController {

    //假设会员系统实现集群化,这里通过同一个应用改端口实现
    @Value("${server.port}")
    private String port;
    @RequestMapping(value = "/getMember",method = RequestMethod.GET)
    public String getMember(){
        return "eureka客户端相应了会员相关信息!" + port;
    }
}
