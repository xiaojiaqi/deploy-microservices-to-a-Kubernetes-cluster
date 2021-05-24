package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.ServiceBResponse;
import com.demo.springcloud.entities.ServiceCResponse;
import com.demo.springcloud.service.CommonService;
import com.demo.springcloud.service.ServiceBApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    CommonService commonService;

    @Autowired
    ServiceBApi serviceBApi;


    @GetMapping(value = "/hellob")
    public CommonResult<ServiceBResponse> helloB() {
        log.info("Call helloB function, Time:" + Long.toString(System.currentTimeMillis()));
        CommonResult<ServiceCResponse> responseC = serviceBApi.helloC();
        ServiceBResponse bResponse = new ServiceBResponse();
        bResponse.setCResponse(responseC.getData());
        bResponse.setBResponse(commonService.getResponse());

        return new CommonResult<>(0L, "成功", bResponse);

    }

    @GetMapping(value = "/hs")
    public String hs() {
        return "OK";
    }
}
