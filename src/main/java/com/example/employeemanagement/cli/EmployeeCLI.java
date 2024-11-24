package com.example.employeemanagement.cli;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeCLI {
    private final EmployeeService employeeService;

    public EmployeeCLI() {
        this.employeeService = new EmployeeService();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Management ===");
            System.out.println("1. Add Employee ");
            System.out.println("2. View All Employees ");
            System.out.println("3. View Employee By ID ");
            System.out.println("4. Update Employee ");
            System.out.println("5. Delete Employee ");
            System.out.println("6. Exit ");
            System.out.println("Choose an Option : ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        addEmployee(scanner);
                        break;
                    case 2:
                        viewAllEmployees();
                        break;
                    case 3:
                        viewEmployeeById(scanner);
                        break;
                    case 4:
                        updateEmployee(scanner);
                        break;
                    case 5:
                        deleteEmployee(scanner);
                        break;
                    case 6: {
                        System.out.println("Exiting...");
                        return;
                    }
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }

    private void addEmployee(Scanner scanner) throws SQLException {
        System.out.print("Enter Id: ");
        int id = scanner.nextInt();

        System.out.print("Enter Name: ");
        String name = scanner.next();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Department: ");
        String department = scanner.next();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, age, department, salary);

        employeeService.addEmployee(employee);
        System.out.println("Employee added successfully!");
    }

    private void viewAllEmployees() throws SQLException {
        // employeeService.getAllEmployees()
        for (Employee employee : employeeService.getAllEmployees()) {
            System.out.println(employee);
        }
    }

    private void viewEmployeeById(Scanner scanner) throws SQLException {
        System.out.print("Enter Employee Id : ");
        int id = scanner.nextInt();
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee Not Found ");
        }
    }

    private void updateEmployee(Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Name: ");
        String name = scanner.next();

        System.out.print("Enter Age:");
        int age = scanner.nextInt();

        System.out.print("Enter Department: ");
        String department = scanner.next();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, age, department, salary);
        employeeService.updateEmployee(employee);
        System.out.println("Employee updated successfully!");
    }

    private void deleteEmployee(Scanner scanner) throws SQLException {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        employeeService.deleteEmployee(id);
        System.out.println("Employee deleted successfully!");
    }
}