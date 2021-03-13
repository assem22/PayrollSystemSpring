package kz.iitu.payrollSystemSpring.controller;

import kz.iitu.payrollSystemSpring.Service.EmployeeService;
import kz.iitu.payrollSystemSpring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    public void updateEmployee(Employee employee){
        employeeService.updateById(employee);
    }
}
