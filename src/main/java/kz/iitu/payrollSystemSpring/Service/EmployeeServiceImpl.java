package kz.iitu.payrollSystemSpring.Service;

import kz.iitu.payrollSystemSpring.entity.Employee;
import kz.iitu.payrollSystemSpring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void updateById(Employee employee) {
        if (employeeRepository.findById(employee.getId()).isPresent()){
            employeeRepository.save(employee);
        }
    }


}
