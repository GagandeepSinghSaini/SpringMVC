package com.training.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.model.EmployeeInfo;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<EmployeeInfo> listEmployee() {
		Session session = sessionFactory.openSession();
		String hqlQuery = "from EmployeeInfo";
		List<EmployeeInfo> empList = new ArrayList<EmployeeInfo>();
		try {
			Query query = session.createQuery(hqlQuery);
			empList = query.list();
		}catch(Exception e) {
			System.out.println("Exception e: "+e);
		}finally {
			session.close();
		}
		System.out.println("empList: "+empList);
		
		return empList;
	}

	@Override
	public void saveEmployee(EmployeeInfo employee) {
		System.out.println("DAO:Save Employee: >>>>>>>>>>>>>>.");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			 tx = session.beginTransaction();
			 EmployeeInfo newEmp = new EmployeeInfo();
			 session.save(employee);
			 tx.commit();
			 session.flush();
		}catch(Exception e) {
			System.out.println("Exception while saving Employee: "+e);
		}finally {
			session.close();
		}
	}

	@Override
	public void deleteEmployee(Integer empId) {
		System.out.println("DAO: deleting employee");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			EmployeeInfo employee = new EmployeeInfo();
			employee.setEmployeeId(empId);
			tx = session.beginTransaction();
			session.delete(employee);
			tx.commit();
		}catch(Exception e) {
			System.out.println("Exception in dao delete employee: "+e);
		}finally {
			session.close();
		}
	}

}
