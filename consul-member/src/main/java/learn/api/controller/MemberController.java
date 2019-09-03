package learn.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    //利用 DiscoveryClient 获取到注册中心的信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public List<ServiceInstance> getInfo(){
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-member");
        for (ServiceInstance instance:instances) {
            System.out.println(instance.getHost() + "@@" + instance.getPort() + "@@" + instance.getUri());
        }
        return instances;
    }
    @RequestMapping(value = "/getMember",method = RequestMethod.GET)
    public String getMember(){
        return "zk替代euerka进行服务治理!";
    }
}
