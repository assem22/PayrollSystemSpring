package kz.iitu.payrollSystemSpring.repository;

import kz.iitu.payrollSystemSpring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
