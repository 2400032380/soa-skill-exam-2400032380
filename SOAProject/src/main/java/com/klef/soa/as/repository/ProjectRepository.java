package com.klef.soa.as.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.soa.as.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>
{
    List<Project> findByName(String name);

    List<Project> findByType(String type);
}