package kz.iitu.payrollSystemSpring.Service;

import kz.iitu.payrollSystemSpring.entity.Employee;

public class SalaryCalculatorService {
    public Employee calculate(Employee employee, double percentage){
        employee.setFixedSalary(employee.getFixedSalary()*((100+percentage)/100));
//        switch (employee.getEmplType()){
//            case SALARIED_COMMISSION:
//                employee.setFixedSalary(employee.getFixedSalary()*((100+percentage)/100));
//                break;
//            case COMMISSION:
//                employee.setFixedSalary(employee.getFixedSalary()*((100+percentage)/100));                break;
//            case HOURLY:
//                employee.setFixedSalary(employee.getFixedSalary()*((100+percentage)/100));
//                break;
//            case MONTHLY:
//                employee.setFixedSalary(employee.getFixedSalary()*((100+percentage)/100));
//                break;
//        }
        return employee;
    }
}
