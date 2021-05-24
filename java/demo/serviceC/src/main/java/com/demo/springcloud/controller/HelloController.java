package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.ServiceCResponse;
import com.demo.springcloud.service.CommonService;
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

    @GetMapping(value = "/helloc")
    public CommonResult<ServiceCResponse> helloC() {
        log.info("Call helloC function, Time:" + Long.toString(System.currentTimeMillis()));


        return new CommonResult<>(0L, "成功", commonService.getResponse());

    }


    @GetMapping(value = "/hs")
    public String hs() {
        return "OK";
    }
}
