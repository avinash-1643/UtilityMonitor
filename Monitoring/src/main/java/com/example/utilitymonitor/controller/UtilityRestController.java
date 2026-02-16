package com.example.utilitymonitor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utilitymonitor.model.UtilityStatus;
import com.example.utilitymonitor.service.UtilityMonitorService;

@RestController
@RequestMapping("/api/utilities")
public class UtilityRestController {

    private final UtilityMonitorService service;

    public UtilityRestController(UtilityMonitorService service) {
        this.service = service;
    }

    @GetMapping("/status")
    public List<UtilityStatus> status() {
        return service.checkAll();
    }
}
