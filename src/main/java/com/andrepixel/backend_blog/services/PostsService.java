package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.PostDTO;
import com.andrepixel.backend_blog.repositories.IGetFilesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PostsService {
    @Qualifier("LocalPostsDatasource")
    @Autowired
    IGetFilesRepository repository;

    public List<PostDTO> getAllPosts() throws IOException {
        ArrayList<PostDTO> posts = new ArrayList<>();

        File directory = repository.getFiles();

        for (int i = 0; i < Objects.requireNonNull(directory.listFiles()).length; i++) {
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
