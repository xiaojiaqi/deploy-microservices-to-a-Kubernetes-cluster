package com.demo.springcloud.service;

import com.demo.springcloud.entities.ServiceCResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */
@Service
public class CommonService {
    @Autowired
    Environment environment;

    public ServiceCResponse getResponse() {

        ServiceCResponse response = new ServiceCResponse();
        String ip = "0.0.0.0";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            ip = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String port = environment.getProperty("server.port");


        response.setServerIp(ip + ":" + port);
        response.setThreadId(Thread.currentThread().getName());
        response.setTimeStamp(Long.toString(System.currentTimeMillis()));
        return response;
    }
}
