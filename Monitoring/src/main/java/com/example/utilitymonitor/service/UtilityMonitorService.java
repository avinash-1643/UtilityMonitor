package com.example.utilitymonitor.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.utilitymonitor.config.UtilityProperties;
import com.example.utilitymonitor.model.UtilityStatus;

@Service
public class UtilityMonitorService {

    private final UtilityProperties properties;
    private final SSHCommandService sshService;

    public UtilityMonitorService(UtilityProperties properties,
                                 SSHCommandService sshService) {
        this.properties = properties;
        this.sshService = sshService;
    }

    public List<UtilityStatus> checkAll() {

        List<UtilityStatus> result = new ArrayList<>();

        if (properties.getServers() == null) {
            return result;
        }

        for (UtilityProperties.ServerConfig server : properties.getServers()) {

            for (UtilityProperties.UtilityConfig util : server.getUtilities()) {

                UtilityStatus status = new UtilityStatus();
                status.setName(util.getName());

                String command =
                        "JAVA".equalsIgnoreCase(util.getType())
                        ? "jps -l | grep " + util.getIdentifier()
                        : "ps -ef | grep " + util.getIdentifier() + " | grep -v grep";

                String output = sshService.execute(
                	    server.getHost(),
                	    server.getUser(),
                	    server.getPassword(),
                	    command
                	);


                if (output != null && !output.trim().isEmpty()) {
                    status.setRunning(true);
                    status.setPid(output.split("\\s+")[1]);
                } else {
                    status.setRunning(false);
                }

                status.setLastChecked(LocalDateTime.now().toString());
                result.add(status);
            }
        }
        return result;
    }
}
