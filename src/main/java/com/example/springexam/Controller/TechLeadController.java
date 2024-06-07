package com.example.springexam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.springexam.Repository.EmployeeRepository;

@Controller
@RequestMapping("/techlead")
public class TechLeadController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public String showEmployeeList(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employeeList";
    }
}
