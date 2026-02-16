package com.example.utilitymonitor.service;

import org.springframework.stereotype.Service;

@Service
public class OSCommandService {

    public String[] buildCommand(String identifier, String type) {
        if ("JAVA".equalsIgnoreCase(type)) {
            return new String[]{"bash", "-c", "jps -l | grep " + identifier};
        }
        return new String[]{"bash", "-c", "ps -ef | grep " + identifier + " | grep -v grep"};
    }
}
