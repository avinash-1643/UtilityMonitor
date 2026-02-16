package com.example.utilitymonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.utilitymonitor.config.UtilityProperties;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(UtilityProperties.class)
public class UtilityMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilityMonitorApplication.class, args);
    }
}
