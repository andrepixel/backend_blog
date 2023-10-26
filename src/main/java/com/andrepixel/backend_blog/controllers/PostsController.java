package com.andrepixel.backend_blog.controllers;

import com.andrepixel.backend_blog.dtos.PostDTO;
import com.andrepixel.backend_blog.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PostsController {

    @Autowired
    PostsService service = new PostsService();

    @GetMapping(
            name = "posts", path = "/posts",
            produces = (MediaType.APPLICATION_JSON_VALUE)
    )
    ResponseEntity<List<PostDTO>> getAllPosts() throws IOException {
        return new ResponseEntity<List<PostDTO>>(
                this.service.getAllPosts(),
                HttpStatus.OK
        );
    }
}