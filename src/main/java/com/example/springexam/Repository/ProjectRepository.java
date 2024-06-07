package com.example.springexam.Repository;
;
import com.example.springexam.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {}


