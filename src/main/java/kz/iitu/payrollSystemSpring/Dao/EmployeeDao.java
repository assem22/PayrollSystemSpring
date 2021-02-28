package kz.iitu.payrollSystemSpring.Dao;

import kz.iitu.payrollSystemSpring.Employee;
import kz.iitu.payrollSystemSpring.EmployeeType;
import kz.iitu.payrollSystemSpring.Event.SalaryChangeEvent;
import kz.iitu.payrollSystemSpring.Service.SalaryCalculatorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@PropertySource("application.properties")
@Component
public class EmployeeDao implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private SalaryCalculatorService calculatorService = new SalaryCalculatorService();

    @Value("${employeeDao.dbUrl}")
    private String dbUrl;

    @Value("${employeeDao.username}")
    private String dbUsername;

    @Value("${employeeDao.password}")
    private String dbPassword;
    Connection connection;
    Statement statement;
    private List<Employee> employees = new ArrayList<>();

    public void salaryChange(Employee employee, double percentage) {
        System.out.println("SALARY OF EMPLOYEE CHANGED");
        System.out.println("employee = " + employee.getName() + "; type: "+ employee.getType());
        employee = calculatorService.calculate(employee, percentage);
        updateEmployees(employee);
        this.eventPublisher.publishEvent(new SalaryChangeEvent(this, employee));
    }

    public void updateEmployees(Employee employee) {
        try {
            String query = "UPDATE employee SET salary = '" + employee.getSalary() +"'  WHERE id = " + employee.getId();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    @PostConstruct
    public void init() throws SQLException {
        this.createDbConnection();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void createDbConnection() throws SQLException {
        // init connection
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            statement = connection.createStatement();
            String queryString = "select * from employee";
            ResultSet rs = statement.executeQuery(queryString);
            while (rs.next()){
                EmployeeType enumVal =  EmployeeType.valueOf(rs.getString(3));
                Employee employee = new Employee(rs.getInt(1), rs.getString(2), enumVal, rs.getInt(4));
                employees.add(employee);
            }
            System.out.println("UserService.createDbConnection");
            System.out.println(employees);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    @PreDestroy
    public void destroyCustom() throws SQLException {
        this.closeConnections();
    }

    public void closeConnections() throws SQLException {
        connection.close();
        System.out.println("UserService.closeConnections");
    }
}
