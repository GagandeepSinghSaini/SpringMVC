package com.training.dao;

import java.util.List;

import com.training.model.EmployeeInfo;

public interface EmployeeDao {

	public List<EmployeeInfo> listEmployee();
	public void saveEmployee(EmployeeInfo employee);
	public void deleteEmployee(Integer empId);
	
}
