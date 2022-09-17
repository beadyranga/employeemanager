package com.rawtechworld.employeemanager.services;

import com.rawtechworld.employeemanager.exceptions.UserNotFoundException;
import com.rawtechworld.employeemanager.model.Employee;
import com.rawtechworld.employeemanager.repo.EmployeeRepo;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmployeeService  {
    private final EmployeeRepo employeeRepo;


    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findByEmployee(id)
                .orElseThrow(()-> new UserNotFoundException("User id "+id+"not found in the system"));
    }

    public void deleteEmployeeById(long id) {
        employeeRepo.deleteById(id);
    }
}
