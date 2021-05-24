package com.demo.springcloud.log.formatter;

import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;


/**
 * @author ppmsn2005@gmail.com
 * @date 2020/10/02
 */
public class JsonFormatter implements Formatter {
    private static final String QUOTE = "\"";
    private static final String COLON = ":";
    private static final String COMMA = ",";
    static String localIp = "";
    private boolean expectJson = false;

    private static void fieldName(String name, StringBuilder sb) {
        quoto(name, sb);
        sb.append(COLON);
    }

    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        return "";
    }

    private static String getip() {
        if (localIp.isEmpty()) {
            localIp = getIpAddress();
        }
        return localIp;
    }

    private static void quoto(String value, StringBuilder sb) {
        sb.append(QUOTE);
        sb.append(value);
        sb.append(QUOTE);
    }

    @Override
    public String format(ILoggingEvent event) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        fieldName("level", sb);
        quoto(event.getLevel().levelStr, sb);
        sb.append(COMMA);

        fieldName("logger", sb);
        quoto(event.getLoggerName(), sb);
        sb.append(COMMA);

        fieldName("timestamp", sb);
        sb.append(event.getTimeStamp());
        sb.append(COMMA);


        fieldName("ip", sb);
        sb.append(getip());
        sb.append(COMMA);

        fieldName("message", sb);
        if (this.expectJson) {
            sb.append(event.getFormattedMessage());
        } else {
            quoto(event.getFormattedMessage(), sb);
        }

        sb.append("}");
        return sb.toString();
    }

    private boolean isExpectJson() {
        return expectJson;
    }

    public void setExpectJson(boolean expectJson) {
        this.expectJson = expectJson;
    }
}
