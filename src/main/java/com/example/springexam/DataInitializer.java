package com.example.springexam;

import com.example.springexam.Model.Employee;
import com.example.springexam.Model.Project;
import com.example.springexam.Repository.EmployeeRepository;
import com.example.springexam.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void run(String... args) throws Exception {
        Project project1 = new Project();
        project1.setName("adidas");
        project1.setBudget(1000.0);

        Project project2 = new Project();
        project2.setName("DotNet");
        project2.setBudget(2000.0);

        projectRepository.saveAll(Arrays.asList(project1, project2));

        Employee employee1 = new Employee();
        employee1.setName("Yasmine");
        employee1.setEmail("yasmine@test.com");
        employee1.setSkills(Arrays.asList("java", ".net", "nodeJS"));
        employee1.setProjects(Arrays.asList(project1));

        Employee employee2 = new Employee();
        employee2.setName("Sara");
        employee2.setEmail("sara@test.com");
        employee2.setSkills(Arrays.asList("Spring", "Angular"));
        employee2.setProjects(Arrays.asList(project2));

        employeeRepository.saveAll(Arrays.asList(employee1, employee2));
    }
}
