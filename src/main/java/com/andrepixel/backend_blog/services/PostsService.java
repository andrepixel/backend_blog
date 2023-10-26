package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.PostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostsService {
    public List<PostDTO> getAllPosts() throws IOException {
        var posts = new ArrayList<PostDTO>();

        var directory = new File("assets/posts/");

        for (int i = 0; i < directory.listFiles().length; i++) {
            var files = directory.listFiles();

            var post = new ObjectMapper().readValue(
                    files[i],
                    PostDTO.class
            );

            posts.add(post);
        }

        return posts;
    }
}
