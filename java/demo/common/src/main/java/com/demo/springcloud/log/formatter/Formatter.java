package com.demo.springcloud.log.formatter;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */
public interface Formatter {
    String format(ILoggingEvent event);
}
