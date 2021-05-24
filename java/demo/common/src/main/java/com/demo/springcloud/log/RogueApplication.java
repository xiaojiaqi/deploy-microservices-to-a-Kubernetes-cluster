package com.demo.springcloud.log;


/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RogueApplication {
    private static final Logger log = LoggerFactory.getLogger(RogueApplication.class);

    public static void main(String[] args) throws InterruptedException {
        int slowCount = 6;
        int fastCount = 15;
        //slow state
        for (int i = 0; i < slowCount; i++) {
            log.warn("This is a warning (slow state)");
            Thread.sleep(5000);
        }

        //enter rapid state
        for (int i = 0; i < fastCount; i++) {
            log.warn("This is a warning (rapid state)");
            Thread.sleep(1000);
        }

        //return to slow state
        for (int i = 0; i < slowCount; i++) {
            log.warn("This is a warning (slow state)");
            Thread.sleep(5000);
        }
    }
}
