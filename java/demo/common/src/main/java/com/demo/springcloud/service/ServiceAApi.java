package com.demo.springcloud.service;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.ServiceBResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component
@FeignClient(value = "b.demo.com")
public interface ServiceAApi {

    @GetMapping(value = "/hellob")
    public CommonResult<ServiceBResponse> helloB();
}
