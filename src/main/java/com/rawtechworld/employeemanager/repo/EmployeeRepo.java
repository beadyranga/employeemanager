package com.rawtechworld.employeemanager.repo;

import com.rawtechworld.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long>  {

    Optional<Employee> findByEmployee(Long id);
}
