package com.wh.learn.api.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestRibbonController {

    private static AtomicInteger countObj = new AtomicInteger(0);

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/testRibbon",method = RequestMethod.GET)
    public String testRibbon(){
        //从注册中心获取服务列表
        List<ServiceInstance> instances = discoveryClient.getInstances("wh-learn-member");
        if (null == instances || instances.size() <= 0) {
            return "没有从服务器获得到相关地址.";
        }
        //取模,确定访问哪个服务
        int andAdd = countObj.addAndGet(1);
        System.out.println("到底是先加了,还是先查了" + andAdd);
        int index = andAdd % instances.size();
        String url = instances.get(index).getUri().toString() + "/getMember";
        //通过resttemplate 请求目标服务
        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }

}
