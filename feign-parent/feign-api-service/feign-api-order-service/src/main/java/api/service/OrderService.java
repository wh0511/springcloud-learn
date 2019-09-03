package api.service;

import com.wh.learn.common.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

public interface OrderService {

    @RequestMapping("/orderToMember")
    public String orderToMember(String name);

    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo();

    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo();
}
