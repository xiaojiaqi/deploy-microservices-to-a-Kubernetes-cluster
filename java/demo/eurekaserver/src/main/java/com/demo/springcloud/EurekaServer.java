package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }
}
