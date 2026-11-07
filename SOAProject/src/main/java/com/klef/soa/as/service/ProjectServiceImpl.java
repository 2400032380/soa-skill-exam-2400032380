package com.klef.soa.as.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.as.entity.Project;
import com.klef.soa.as.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService
{
    @Autowired
    private ProjectRepository repo;

    @Override
    public Project addProject(Project project)
    {
        return repo.save(project);
    }

    @Override
    public List displayAllProjects()
    {
        return repo.findAll();
    }

    @Override
    public Project updateProject(Project p)
    {
        Optional optional = repo.findById(p.getProjectId());

        if(optional.isPresent())
        {
            Project project = (Project) optional.get();

            project.setName(p.getName());
            project.setType(p.getType());
            project.setStatus(p.getStatus());
            project.setLocation(p.getLocation());

            return repo.save(project);
        }
        else
        {
            return null;
        }
    }

    @Override
    public Project displayProjectById(Long projectId)
    {
        return repo.findById(projectId).orElse(null);
    }

    @Override
    public String deleteProjectById(Long projectId)
    {
        boolean status = repo.existsById(projectId);

        if(status)
        {
            repo.deleteById(projectId);
            return "Project Deleted Successfully";
        }
        else
        {
            return "Project ID Not Found";
        }
    }

    @Override
    public List displayProjectByName(String name)
    {
        return repo.findByName(name);
    }

    @Override
    public List displayProjectByType(String type)
    {
        return repo.findByType(type);
    }
}