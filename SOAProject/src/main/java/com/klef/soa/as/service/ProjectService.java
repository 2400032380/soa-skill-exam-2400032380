package com.klef.soa.as.service;

import java.util.List;

import com.klef.soa.as.entity.Project;

public interface ProjectService 
{
    Project addProject(Project project);
    
    List<Project> displayAllProjects();
    
    Project updateProject(Project p);
    
    Project displayProjectById(Long projectId);
    
    String deleteProjectById(Long projectId);
    
    List<Project> displayProjectByName(String name);
    
    List<Project> displayProjectByType(String type);
}