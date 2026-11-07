package com.klef.soa.as.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.as.entity.Project;
import com.klef.soa.as.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController
{
    @Autowired
    private ProjectService service;

    @GetMapping("/")
    public String test()
    {
        return "SOA Programming & MicroServices";
    }

    // Add Project
    @PostMapping("/add") 
    public ResponseEntity<Project> addProject(@RequestBody Project p) 
    { 
        Project project = service.addProject(p); 
        return ResponseEntity.status(201).body(project); 
    }

    @GetMapping("/displayall")
    public ResponseEntity<List<Project>> displayAllProjects()
    {
        List<Project> projects = service.displayAllProjects(); 
        return ResponseEntity.status(200).body(projects);
    }

  
    @GetMapping("/display")
    public ResponseEntity<?> displayProjectById(@RequestParam Long id)
    {
        Project project = service.displayProjectById(id);

        if(project != null)
        {
            return ResponseEntity.status(200).body(project);
        }
        else
        {
            return ResponseEntity.status(404).body("Project ID Not Found");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProject(@RequestBody Project project)
    {
        Project p = service.updateProject(project);

        if(p != null)
        {
            return ResponseEntity.ok(p);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Project ID Not Found");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProjectById(@PathVariable Long id)
    {
        String message = service.deleteProjectById(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @GetMapping("/displaybyname/{name}")
    public ResponseEntity<List<Project>> displayProjectsByName(
            @PathVariable String name)
    {
        List<Project> projects = service.displayProjectByName(name);

        return ResponseEntity.status(200).body(projects);
    }

   
    @GetMapping("/displaybytype/{type}")
    public ResponseEntity<List<Project>> displayProjectsByType(
            @PathVariable String type)
    {
        List<Project> projects = service.displayProjectByType(type);

        return ResponseEntity.status(200).body(projects);
    }
}