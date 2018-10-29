package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.exception.GenericException;
import com.training.model.EmployeeInfo;
import com.training.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcomeEmployee(ModelMap model) {
		System.out.println("I am welcoming the employee >>>>>>>>>>>>>");
		model.addAttribute("name", "Gagandeep Singh Saini");
		model.addAttribute("greetings", "Welcome to Spring MVC !!");
		return "hello";
	}
	
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String listEmployee(ModelMap model) {
		System.out.println("Getting the employee list >>>>>>>>>>>>>");
		model.addAttribute("employeeList", employeeService.emplList());
		return "employee";
	}
	
	@RequestMapping(value = "/testGenericException")
	public String testGenericException(ModelMap model) throws GenericException {
		System.out.println("GEtting Generic Exception >>>>>>>>>");
		if(true) {
			throw new GenericException("1000", "OOPS!, Exception comes while testing generic exception");
		}
		return "employee";
	}
	
	@RequestMapping(value = "/addemployee")
	public ModelAndView addEmployee(ModelMap model) {
		model.addAttribute("employeeList", employeeService.emplList());
		return new ModelAndView("addemployee", "command", new EmployeeInfo());
	}
	
	@RequestMapping(value = "/updateemployee", method = RequestMethod.POST)  //240
	public String updateEmployee(@ModelAttribute("command") EmployeeInfo employee, ModelMap model) {
		try {
			System.out.println("Controller : Save Employee: >>>>>>>>>>>>>>.");
			this.employeeService.insertEmployee(employee);
			model.addAttribute("employeeList", employeeService.emplList());
		}catch(Exception e) {
			System.out.println("Exception in Controller while updating: "+e);
		}
		return "addemployee";
	}
	
	@RequestMapping(value = "/delete/{employeeId}")
	public String delete(@PathVariable("employeeId") Integer employeeId, ModelMap model) {
		System.out.println("Controller: deleting the employee");
		this.employeeService.deleteEmployee(employeeId);
		model.addAttribute("command", new EmployeeInfo());
		model.addAttribute("employeeList", employeeService.emplList());
		return "addemployee";
	}
	
}
