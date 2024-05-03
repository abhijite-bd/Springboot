package com.example.showdatabase.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.showdatabase.demo.model.EmployeeModel;

@Service
public interface EmployeeService {
    List<EmployeeModel> showAllEmployee();

    void saveEmployee(EmployeeModel model);
}
