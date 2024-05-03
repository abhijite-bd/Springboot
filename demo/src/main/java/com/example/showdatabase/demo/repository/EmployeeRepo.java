package com.example.showdatabase.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.showdatabase.demo.model.EmployeeModel;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel, Long> {

}
