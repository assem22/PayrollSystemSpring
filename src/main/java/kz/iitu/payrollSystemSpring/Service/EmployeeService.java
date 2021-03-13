package kz.iitu.payrollSystemSpring.Service;

import kz.iitu.payrollSystemSpring.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    void updateById(Employee employee);
}
