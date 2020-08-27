package com.allsafe.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class Response {
	private int Status;
	private String urlName;

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

}
