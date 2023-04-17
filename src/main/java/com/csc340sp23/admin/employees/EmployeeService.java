package com.csc340sp23.admin.employees;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christopher Jacobs
 */
@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployee(long employeeId) {
        return repo.getReferenceById(employeeId);
    }

    public void deleteEmployee(long employeeId) {
        repo.deleteById(employeeId);
    }

    public void saveEmployee(Employee employee) {
        
        repo.save(employee);
    }
}
