package com.andrepixel.backend_blog.controllers;

import com.andrepixel.backend_blog.dtos.ProjectDTO;
import com.andrepixel.backend_blog.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ProjectsController {
    @Autowired
    ProjectsService service = new ProjectsService();

    @GetMapping(
            name = "projects", path = ("/projects"),
            produces = (MediaType.APPLICATION_JSON_VALUE)
    )
    ResponseEntity<List<ProjectDTO>> getAllPosts() throws IOException {
        return new ResponseEntity<List<ProjectDTO>>(
                this.service.getAllProjects(),
                HttpStatus.OK
        );
    }
}
