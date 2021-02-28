package kz.iitu.payrollSystemSpring;

import kz.iitu.payrollSystemSpring.Dao.EmployeeDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static EmployeeDao employeeDao;
    private static AnnotationConfigApplicationContext context;
    public static void main(String[] args){
        context = new AnnotationConfigApplicationContext();
        context.scan("kz.iitu.payrollSystemSpring");
        context.refresh();
        employeeDao = context.getBean("employeeDao", EmployeeDao.class);

        System.out.println(employeeDao.getEmployees());
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
                for (Employee employee: employeeDao.getEmployees()){
                    if (employee.getType() == EmployeeType.SALARIZEDCOMMISSION){
                        employeeDao.salaryChange(employee, percentage);
                    }
                }
                break;
            case 2:
                System.out.println("Enter the percentage of salary for hourly employees:");
//                double coef = in.nextDouble();
                percentage = in.nextDouble();
                for (Employee employee: employeeDao.getEmployees()){
                    if (employee.getType() == EmployeeType.HOURLY){
                        employeeDao.salaryChange(employee, percentage);
                    }
                }
                break;
            case 3:
                System.out.println("Enter the percentage of salary for commission employees:");
                percentage = in.nextDouble();
                for (Employee employee: employeeDao.getEmployees()){
                    if (employee.getType() == EmployeeType.COMMISSION){
                        employeeDao.salaryChange(employee, percentage);
                    }
                }
                break;
            case 4:
                System.out.println("Enter the percentage of salary for salaried employees:");
                percentage = in.nextDouble();
                for (Employee employee: employeeDao.getEmployees()){
                    if (employee.getType() == EmployeeType.MONTHLY){
                        employeeDao.salaryChange(employee, percentage);
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
