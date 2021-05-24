package com.demo.springcloud.service;

/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.ServiceCResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "c.demo.com")
public interface ServiceBApi {
    @GetMapping(value = "/helloc")
    public CommonResult<ServiceCResponse> helloC();
}
