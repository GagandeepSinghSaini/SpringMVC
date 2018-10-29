package com.training.service;

import java.util.List;

import com.training.model.EmployeeInfo;

public interface EmployeeService {

	public List<EmployeeInfo> emplList();
	public void insertEmployee(EmployeeInfo employee);
	public void deleteEmployee(Integer employeeId);
	
}
