package com.springboot.reactive.repository;


import com.springboot.reactive.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {
}
