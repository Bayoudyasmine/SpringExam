package com.example.springexam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springexam.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
