package com.example.employeemanagement.dao;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO employee(id,name,age,department,salary) VALUE(?,?,?,?,?)";

        try (Connection connection = DBConnectionUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getDepartment());
            ps.setDouble(5, employee.getSalary());
            ps.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        String query = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DBConnectionUtil.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getDouble("salary")));
            }
        }
        return employees;
    }

    public Employee getEmployeeById(int id) throws SQLException {
        String query = "SELECT * FROM employee WHERE id= ? ";
        try (Connection connection = DBConnectionUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getDouble("salary"));
            }
        }
        return null;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE employee SET name=?,age=?,department=?,salary=? WHERE id=?";
        try (Connection connection = DBConnectionUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());
            ps.setInt(5, employee.getId());
            ps.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employee WHERE id=?";
        try (Connection connection = DBConnectionUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }
}