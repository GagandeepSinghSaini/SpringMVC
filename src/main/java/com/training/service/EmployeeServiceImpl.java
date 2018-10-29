package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.EmployeeDao;
import com.training.model.EmployeeInfo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public List<EmployeeInfo> emplList() {
		return this.employeeDao.listEmployee();
	}

	@Override
	public void insertEmployee(EmployeeInfo employee) {
		employeeDao.saveEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

	
}
