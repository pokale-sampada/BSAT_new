//package com.omfys.bsat.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Controller
//public class Testing {
//	@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("/java")
//	public String java()
//	{
//		return "Running Java";
//		
//	}
//	@GetMapping("/python")
//	public String python()
//	{
//		return "Running python";
//		
//	}
//
//
//
// 
//	//@PreAuthorize("hasRole('ADMIN')")
//	@RequestMapping("/signin")
//	public String mobile()
//	{
//		
//		System.out.println("hitt the page");
//		return "mobile.html";
//		
//	}
//	@GetMapping("/python2")
//	public String python2()
//	{
//		return "Running python";
//		
//	}
//
//}
