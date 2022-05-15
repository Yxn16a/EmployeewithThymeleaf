package com.example.employeewiththymeleaf.repository;

import com.example.employeewiththymeleaf.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
