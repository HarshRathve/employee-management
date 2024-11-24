package com.example.employeemanagement;

import com.example.employeemanagement.cli.EmployeeCLI;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        EmployeeCLI employeeCLI = new EmployeeCLI();
        employeeCLI.start();
        return;
    }
}
