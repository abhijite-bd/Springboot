package com.example.showdatabase.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.showdatabase.demo.model.EmployeeModel;
import com.example.showdatabase.demo.repository.EmployeeRepo;
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeModel> showAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public void saveEmployee(EmployeeModel model) {
        this.employeeRepo.save(model);
    }
}
