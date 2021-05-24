package com.demo.springcloud.entities;

import lombok.Data;

/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */
@Data
public class ServiceCResponse {
    /*
       运行服务的线程名
     */
    String threadId;
    /*
       运行的时间戳
     */
    String timeStamp;
    /*
       本机的ip
     */
    String serverIp;
}
