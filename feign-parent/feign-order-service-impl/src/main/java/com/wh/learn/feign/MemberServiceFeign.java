package com.wh.learn.feign;

import com.wh.learn.api.entity.User;
import com.wh.learn.api.service.MemberService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("app-wh-member")
public interface MemberServiceFeign extends MemberService {

}
