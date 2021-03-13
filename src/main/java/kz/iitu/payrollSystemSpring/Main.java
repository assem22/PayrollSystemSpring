package kz.iitu.payrollSystemSpring;

import kz.iitu.payrollSystemSpring.Service.SalaryCalculatorService;
import kz.iitu.payrollSystemSpring.config.SpringConfig;
import kz.iitu.payrollSystemSpring.controller.EmployeeController;
import kz.iitu.payrollSystemSpring.entity.Employee;
import kz.iitu.payrollSystemSpring.entity.EmployeeType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static EmployeeController controller;
    private static SalaryCalculatorService calculatorService = new SalaryCalculatorService();
    private static AnnotationConfigApplicationContext context;

    private static Employee employee = new Employee();

    public static void main(String[] args){
        context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        controller = context.getBean("employeeController", EmployeeController.class);
        System.out.println(controller.getEmployees());
        while(true){
            menu();
        }
    }

    private static void menu() {
        System.out.println("[1] reward salaried-commission\n" +
                "[2] reward hourly employees\n" +
                "[3] reward commission employees\n" +
                "[4] reward salaried employees\n" +
                "[5] exit");
        int choice = in.nextInt();
        double percentage;

        switch(choice){
            case 1:
                System.out.println("Enter the percentage of salary for salaried-commission employees:");
                percentage = in.nextDouble();
                for (Employee employee: controller.getEmployees()){
                    if (employee.getEmplType() == EmployeeType.SALARIED_COMMISSION){
                        employee = calculatorService.calculate(employee, percentage);
                        controller.updateEmployee(employee);
                    }
                }
                break;
            case 2:
                System.out.println("Enter the percentage of salary for hourly employees:");
//                double coef = in.nextDouble();
                percentage = in.nextDouble();
                for (Employee employee: controller.getEmployees()){
                    if (employee.getEmplType() == EmployeeType.HOURLY){
                        employee = calculatorService.calculate(employee, percentage);
                        controller.updateEmployee(employee);
                    }
                }
                break;
            case 3:
                System.out.println("Enter the percentage of salary for commission employees:");
                percentage = in.nextDouble();
                for (Employee employee: controller.getEmployees()){
                    if (employee.getEmplType() == EmployeeType.COMMISSION){
                        employee = calculatorService.calculate(employee, percentage);
                        controller.updateEmployee(employee);
                    }
                }
                break;
            case 4:
                System.out.println("Enter the percentage of salary for salaried employees:");
                percentage = in.nextDouble();
                for (Employee employee: controller.getEmployees()){
                    if (employee.getEmplType() == EmployeeType.MONTHLY){
                        employee = calculatorService.calculate(employee, percentage);
                        controller.updateEmployee(employee);
                    }
                }
                break;
            case 5:
                context.close();
                System.exit(0);
                break;
        }
    }
}
