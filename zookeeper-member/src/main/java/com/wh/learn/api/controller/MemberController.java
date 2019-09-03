package com.wh.learn.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @RequestMapping(value = "/getMember",method = RequestMethod.GET)
    public String getMember(){
        return "zk替代euerka进行服务治理!";
    }
}
