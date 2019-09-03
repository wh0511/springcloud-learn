package learn.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    public String getOrder(){
        String url = "http://zk-member:8002/getMember";
        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }
}
