package com.wh.learn.api.service;

import com.wh.learn.api.entity.User;
import com.wh.learn.common.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface MemberService {

    @RequestMapping("/getMember")
    public User getMember(@RequestParam("name") String name);

    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo();
}
