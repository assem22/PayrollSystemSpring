package kz.iitu.payrollSystemSpring.Service;

import kz.iitu.payrollSystemSpring.Employee;

public class SalaryCalculatorService {
    public Employee calculate(Employee employee, double percentage){
        employee.setSalary(employee.getSalary()*((100+percentage)/100));
//        switch (employee.getType()){
//            case SALARIZEDCOMMISSION:
//                employee.setSalary(employee.getSalary()*((100+percentage)/100));
//                break;
//            case COMMISSION:
//
//                break;
//            case HOURLY:
//
//                break;
//            case MONTHLY:
//                employee.setSalary(employee.getSalary()*((100+percentage)/100));
//                break;
//        }
        return employee;
    }
}
