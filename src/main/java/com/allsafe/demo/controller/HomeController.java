package com.allsafe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.allsafe.demo.entity.Response;
import com.allsafe.demo.service.WebStatusService;

@Controller
public class HomeController {
	
	@Autowired
	public WebStatusService webStatusService;
	
	@Autowired
	public Response response;

	@RequestMapping("/home")
	public String home(Model theModel)
	{
		webStatusService.RunStatus();
		
		theModel.addAttribute("statusCode", response.getStatus());
		return "index.html";
	}
	@RequestMapping("/search")
	public String search(@RequestParam(value ="urlName") String urlName,Model theModel)
	{
		response.setUrlName(urlName);
		webStatusService.RunStatus();
		theModel.addAttribute("statusCode", response.getStatus());
		return "index.html";
	}
	
}
