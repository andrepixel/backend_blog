package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.ProjectDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectsService {
    public List<ProjectDTO> getAllProjects() throws IOException {
        var projects = new ArrayList<ProjectDTO>();

        var directory = new File("assets/projects/");

        for (int i = 0; i < directory.listFiles().length; i++) {
            var files = directory.listFiles();

            var project = new ObjectMapper().readValue(
                    files[i],
                    ProjectDTO.class
            );

            projects.add(project);
        }

        return projects;
    }
}
