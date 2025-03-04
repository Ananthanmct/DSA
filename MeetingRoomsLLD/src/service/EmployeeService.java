package service;

import factory.Factory;
import models.Employee;
import repo.EmployeeDB;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    EmployeeDB employeeDB;

    public EmployeeService(Factory factory){
        this.employeeDB = factory.provideEmployeeDB();
    }

    public List<Employee> getEmployees(List<Integer> employeeIds){
        List<Employee> employees = new ArrayList<>();
        for(Integer id : employeeIds){
            employees.add(employeeDB.getById(id));
        }
        return employees;
    }

    public void createEmployee(int id, String name){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setCalendar(new ArrayList<>());
        employeeDB.addEmployee(id, employee);
    }
}
