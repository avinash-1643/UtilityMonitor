package com.example.utilitymonitor.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.utilitymonitor.model.UtilityStatus;
import com.example.utilitymonitor.service.UtilityMonitorService;

@Component
@EnableScheduling
public class UtilityScheduler {

    @Autowired
    private UtilityMonitorService service;

    private List<UtilityStatus> latest;

    @Scheduled(fixedDelay = 30000)
    public void monitor() {
        latest = service.checkAll();
    }

    public List<UtilityStatus> getLatest() {
        return latest;
    }
}
