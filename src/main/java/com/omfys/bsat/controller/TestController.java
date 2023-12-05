package com.omfys.bsat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/eat")
	public String eat()
	{
		return "eating";
		
	}
	@RequestMapping("/run")
	public String run()
	{
		return "runing";
		
	}
	@RequestMapping("/sleep")
	public String sleep()
	{
		return "sleeping";
		
	}

}
