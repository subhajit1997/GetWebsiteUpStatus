package com.allsafe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allsafe.demo.config.WebStatusConfig;
import com.allsafe.demo.entity.Response;

@Service
public class WebStatusService {

	@Autowired
	public WebStatusConfig webStatusConfig;
	
	@Autowired
	public Response response;
	
	public void RunStatus()
	{
		String url=response.getUrlName();
		if(webStatusConfig.getStatus(url))
		{
			response.setStatus(200);
		}
		else
			response.setStatus(500);
	}
}
