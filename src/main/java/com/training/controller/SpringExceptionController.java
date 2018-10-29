package com.training.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.training.exception.GenericException;

@ControllerAdvice
public class SpringExceptionController {

	@ExceptionHandler(Exception.class)
	public ModelAndView allException(Exception e) {
		ModelAndView modelAndView = new ModelAndView("error/exception");
		modelAndView.addObject("error",e.getClass().getSimpleName());
		return modelAndView;
	}
	
	@ExceptionHandler(GenericException.class)
	public ModelAndView genericException(GenericException ex) {
		System.out.println("in genericException >>>>>>>>>>>>");
		ModelAndView modelAndView = new ModelAndView("error/exception");
		modelAndView.addObject("error",ex.getClass().getSimpleName());
		modelAndView.addObject("message",ex.getResponseCode()+" - "+ex.getResponseMsg());
		return modelAndView;
	}
}
