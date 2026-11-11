
package com.klef.soa.as.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.as.entity.Project;
import com.klef.soa.as.repository.ProjectRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjectRepositoryTest
{
    @Autowired
    private ProjectRepository repository;

    @Test
    void testFindAllProjects()
    {
        List<Project> projects = repository.findAll();
        assertNotNull(projects);
        assertFalse(projects.isEmpty());
        System.out.println("Total Projects: " + projects.size());
    }

    @Test
    void testFindProjectById()
    {
        Optional<Project> project = repository.findById(1L);
        assertTrue(project.isPresent());
        assertEquals("ram", project.get().getName());
        assertEquals("wep application", project.get().getType());
        assertEquals("active", project.get().getStatus());
        assertEquals("vizag", project.get().getLocation());

        System.out.println("Project ID: " + project.get().getProjectId());
        System.out.println("Project Name: " + project.get().getName());
        System.out.println("Project Type: " + project.get().getType());
        System.out.println("Project Status: " + project.get().getStatus());
        System.out.println("Project Location: " + project.get().getLocation());
    }

    @Test
    void testFindProjectByType()
    {
        List<Project> projects = repository.findByType("wep application");
        assertNotNull(projects);
        assertFalse(projects.isEmpty());
        assertEquals("wep application", projects.get(0).getType());

        System.out.println("Project Type: " + projects.get(0).getType());
    }

    @Test
    void testFindProjectByName()
    {
        List<Project> projects = repository.findByName("ram");
        assertNotNull(projects);
        assertFalse(projects.isEmpty());
        assertEquals("ram", projects.get(0).getName());

        System.out.println("Project Name: " + projects.get(0).getName());
    }

    @Test
    void testDatabaseConnection()
    {
        long count = repository.count();
        assertTrue(count >= 1);
        System.out.println("Total Projects in Database: " + count);
    }
}
