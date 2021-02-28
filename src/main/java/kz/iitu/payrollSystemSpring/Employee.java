package kz.iitu.payrollSystemSpring;

public class Employee {
    private int id;
    private String name;
    private EmployeeType type;
    private double salary;

    public Employee(int id, String name, EmployeeType type, double salary) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", salary=" + salary +
                '}';
    }
}
