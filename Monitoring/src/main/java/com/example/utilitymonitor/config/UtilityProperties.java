package com.example.utilitymonitor.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "utilities")
public class UtilityProperties {

    private List<ServerConfig> servers;

    public static class ServerConfig {
        private String host;
        private String user;
        private String password;
        private List<UtilityConfig> utilities;

        public String getHost() { return host; }
        public void setHost(String host) { this.host = host; }

        public String getUser() { return user; }
        public void setUser(String user) { this.user = user; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }

        public List<UtilityConfig> getUtilities() { return utilities; }
        public void setUtilities(List<UtilityConfig> utilities) { this.utilities = utilities; }
    }


    public static class UtilityConfig {
        private String name;
        private String identifier;
        private String type;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getIdentifier() { return identifier; }
        public void setIdentifier(String identifier) { this.identifier = identifier; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
    }

    public List<ServerConfig> getServers() {
        return servers;
    }

    public void setServers(List<ServerConfig> servers) {
        this.servers = servers;
    }
}
