package com.omfys.bsat.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ModelAndView ResourceNotFound(@PathVariable("name") final String name,HttpServletRequest request, ModelMap map,Model model) {
		if(name.equals("null")) throw new ResourceNotFoundException();
		return new ModelAndView("error_404");
	}

	 @ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IOException.class)
	 public ModelAndView handleResourceNotFoundException() {
//		 return "error_404";
		 return new ModelAndView("error_404");
	 }
	 
	 @ResponseStatus(HttpStatus.NOT_FOUND)
		@ExceptionHandler(ResourceNotFoundException.class)
		 public ModelAndView handleResourceNotFoundException2() {
//			 return "error_404";
			 return new ModelAndView("error_404");
		 }
}
