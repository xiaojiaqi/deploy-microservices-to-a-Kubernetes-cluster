package com.demo.springcloud;


import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 */
@EnableEurekaClient
@SpringBootApplication
public class AppC {
    public static void main(String[] args) {
        SpringApplication.run(AppC.class, args);
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(
            @Value("${spring.application.name}") String applicationName) {

        return (registry) -> registry.config().commonTags("application", applicationName);

    }
}
