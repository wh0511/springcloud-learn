package com.wh.learn.api.impl;

import com.wh.learn.api.entity.User;
import com.wh.learn.api.service.MemberService;
import com.wh.learn.common.BaseApiService;
import com.wh.learn.common.ResponseBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService implements MemberService {

    @Value("${server.port}")
    private String serverPort;
    @Override
    @RequestMapping("/getMember")
    public User getMember(String name) {
        User user = new User();
        user.setName(name);
        user.setAge("20");
        return user;
    }

    @Override
    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() {
        System.out.println("进了会员的方法了!");
        try{
            //1.5秒延迟
            Thread.sleep(1500);
        }catch (Exception e){

        }
        return setResultSuccess("调用会员getUserInfo接口成功");
    }
}
