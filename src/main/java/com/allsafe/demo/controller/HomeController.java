package com.allsafe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.allsafe.demo.entity.Response;
import com.allsafe.demo.service.WebStatusImpl;
import com.allsafe.demo.service.WebStatusService;

@Controller
public class HomeController {

	@Autowired
	public WebStatusService webStatusService;

	@Autowired
	public Response response;

	@Autowired
	public WebStatusImpl webStatusImpl;

	@RequestMapping("/home")
	public String home(Model theModel) {
		webStatusImpl.FileWrite();
		return "index.html";
	}

	@RequestMapping("/search")
	public String search(@RequestParam(value = "urlName") String urlName, Model theModel) {
		response.setUrlName(urlName);
		webStatusImpl.toggle(true);
		return "chart.html";
	}
	
	@RequestMapping("/stop")
	public String stop()
	{
		webStatusImpl.toggle(false);
		return "index.html";
		
	}

}
