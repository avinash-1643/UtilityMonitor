package com.example.utilitymonitor.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Service
public class SSHCommandService {

	public String execute(String host, String user, String password, String command) {

	    Session session = null;
	    ChannelExec channel = null;

	    try {
	        JSch jsch = new JSch();
	        session = jsch.getSession(user, host, 22);

	        session.setPassword(password); // 🔑 ADD THIS

	        Properties config = new Properties();
	        config.put("StrictHostKeyChecking", "no");
	        session.setConfig(config);
	        session.setConfig("StrictHostKeyChecking", "no");
	        session.setConfig("PreferredAuthentications", "password");
	        session.connect(10000);

	        channel = (ChannelExec) session.openChannel("exec");
	        channel.setCommand(command);

	        BufferedReader reader =
	                new BufferedReader(new InputStreamReader(channel.getInputStream()));

	        channel.connect();

	        return reader.readLine();

	    } catch (Exception e) {
	        e.printStackTrace(); // TEMP: keep for debugging
	        return null;
	    } finally {
	        if (channel != null) channel.disconnect();
	        if (session != null) session.disconnect();
	    }
	}

}
