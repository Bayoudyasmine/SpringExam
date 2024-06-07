package com.example.springexam.Controller;

import com.example.springexam.Model.Employee;
import com.example.springexam.Model.Project;
import com.example.springexam.Repository.EmployeeRepository;
import com.example.springexam.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class ManagerController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/assign")
    public String showAssignForm(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        return "assign";
    }

    @PostMapping("/assign")
    public String assignProject(@RequestParam Long employeeId, @RequestParam Long projectId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        Project project = projectRepository.findById(projectId).orElseThrow();
        employee.getProjects().add(project);
        employeeRepository.save(employee); // Corrected line
        return "redirect:/admin/assign";
    }
}
