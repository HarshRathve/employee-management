package com.example.employeemanagement.service;

import com.example.employeemanagement.dao.EmployeeDAO;
import com.example.employeemanagement.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService
{
	private final EmployeeDAO employeeDAO;
	
	public EmployeeService()
	{
		this.employeeDAO=new EmployeeDAO();
	}
	
	public void addEmployee(Employee employee) throws SQLException
	{
		employeeDAO.addEmployee(employee);
	}

	public List<Employee> getAllEmployees() throws SQLException
	{
		return employeeDAO.getAllEmployees();
	}

	public Employee getEmployeeById(int id) throws SQLException
	{
		return employeeDAO.getEmployeeById(id);
	}
	
	public void updateEmployee(Employee employee) throws SQLException
	{
     	        employeeDAO.updateEmployee(employee);
	}

  	public void deleteEmployee(int id) throws SQLException
	{
       		 employeeDAO.deleteEmployee(id);
        }
}