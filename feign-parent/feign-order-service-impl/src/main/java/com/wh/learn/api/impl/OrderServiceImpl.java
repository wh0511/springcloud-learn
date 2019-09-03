package com.wh.learn.api.impl;

import api.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.wh.learn.api.entity.User;
import com.wh.learn.common.BaseApiService;
import com.wh.learn.common.ResponseBase;
import com.wh.learn.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl extends BaseApiService implements OrderService {

    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @Override
    @RequestMapping("/orderToMember")
    public String orderToMember(String name) {
        User member = memberServiceFeign.getMember(name);
        return null == member ? "没有获取到结果!":member.toString();
    }

    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo(){
        ResponseBase userInfo = memberServiceFeign.getUserInfo();
        return userInfo == null ? setResultSuccess("未能从会员服务获得数据"):userInfo;
    }

    @Override
    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo() {
        System.out.println("线程池名称:" + Thread.currentThread().getName());
        return setResultSuccess("访问成功!");
    }

    //hystrix 解决服务器雪崩的方式一 注解方式
    //hystrix 默认开启,默认开启服务降级,默认开启线程池隔离,默认开启熔断
    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
    @RequestMapping("/orderToMemberUserInfoHystrix")
    public ResponseBase orderToMemberUserInfoHystrix(){
        System.out.println("线程池名称:" + Thread.currentThread().getName());
        ResponseBase userInfo = memberServiceFeign.getUserInfo();
        return userInfo == null ? setResultSuccess("未能从会员服务获得数据"):userInfo;
    }

    public ResponseBase orderToMemberUserInfoHystrixFallback(){

        return setResultSuccess("返回一个友好的提示:服务器忙,请稍后再试!");
    }



}
