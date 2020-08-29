package com.allsafe.demo.config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebStatusConfig {
	public  boolean getStatus(String url) {

	    try {
	    	 int timeout=10000;
	        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	        connection.setConnectTimeout(timeout);
	        connection.setReadTimeout(timeout);
	        connection.setRequestMethod("HEAD");
	        int responseCode = connection.getResponseCode();
	        return (200 <= responseCode && responseCode <= 399);
	    } catch (IOException exception) {
	        return false;
	    }
	}
}
