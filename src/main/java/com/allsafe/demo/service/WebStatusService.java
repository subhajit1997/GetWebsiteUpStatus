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
	
	
	public int RunStatus()
	{
		String url=response.getUrlName();
		System.out.println("url: "+url);
		int responseCode;
		if(webStatusConfig.getStatus(url))
		{
			responseCode=200;
			response.setStatus(responseCode);
			System.out.println("response code: "+200);
		}
		else
		{
			responseCode=500;
			response.setStatus(responseCode);
			System.out.println("response code: "+500);

		}
		return responseCode;
		
	}
}
