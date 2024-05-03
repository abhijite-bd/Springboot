package com.example.showdatabase.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.showdatabase.demo.model.EmployeeModel;
import com.example.showdatabase.demo.repository.EmployeeRepo;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/")
    public String showData(Model model) {
        model.addAttribute("list", employeeRepo.findAll());
        return "index";
    }

    @GetMapping("/createNewEmployee")
    public String createNewEmployee(Model model) {
        EmployeeModel employeeModel = new EmployeeModel();
        model.addAttribute("employee", employeeModel);
        return "New_employee";
    }

    @PostMapping("/savedEmployee")
    public String savedEmployee(@ModelAttribute("employee") EmployeeModel employeeModel) {
        employeeRepo.save(employeeModel);
        return "redirect:/";
    }

    @GetMapping("/EmployeeUpdate/{id}")
    public String EmployeeUpdate(@PathVariable(value = "id") long id, Model model) {
        System.out.println(id);
        EmployeeModel employeeModel = employeeRepo.getById(id);
        model.addAttribute("employee", employeeModel);
        return "Update_employee";
    }

    @GetMapping("/EmployeeDelete/{id}")
    public String EmployeeDelete(@PathVariable(value = "id") long id) {
        System.out.println(id);
        this.employeeRepo.deleteById(id);
        return "redirect:/";
    }
}
