package com.demo.springcloud.servicea.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.ServiceAResponse;
import com.demo.springcloud.entities.ServiceBResponse;
import com.demo.springcloud.service.CommonService;
import com.demo.springcloud.service.ServiceAApi;
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
public class controller {


    @Autowired
    private CommonService commonService;

    @Autowired
    private ServiceAApi serviceAApi;

    @GetMapping(value = "/helloa")
    public CommonResult<ServiceAResponse> helloA() {

        log.info("Call helloA function, Time:" + Long.toString(System.currentTimeMillis()));
        CommonResult<ServiceBResponse> responseB = serviceAApi.helloB();
        ServiceAResponse aResponse = new ServiceAResponse();
        aResponse.setAResponse(commonService.getResponse());
        aResponse.setBResponse(responseB.getData());
        return new CommonResult<>(0L, "成功", aResponse);

    }


    @GetMapping(value = "/hs")
    public String hs() {
        return "OK";
    }
}
