package com.example.utilitymonitor.model;

public class UtilityStatus {
    private String name;
    private boolean running;
    private String pid;
    private String lastChecked;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isRunning() { return running; }
    public void setRunning(boolean running) { this.running = running; }
    public String getPid() { return pid; }
    public void setPid(String pid) { this.pid = pid; }
    public String getLastChecked() { return lastChecked; }
    public void setLastChecked(String lastChecked) { this.lastChecked = lastChecked; }
}
