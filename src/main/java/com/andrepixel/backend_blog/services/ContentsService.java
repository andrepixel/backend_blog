package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.ContentDTO;
import com.andrepixel.backend_blog.repositories.IContentsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Service
public class ContentsService {

    @Autowired
    IContentsRepository repository;

    public ContentDTO getContentPostsImages(String nameFile) throws IOException {
        ContentDTO content = new ContentDTO();

        File file = this.repository.getFile(nameFile + ".jpg");

        content.setImage(file.getPath());

        return content;
    }

    public ContentDTO getContentProjectsImages(String nameFile) throws IOException {
        var content = new ContentDTO();

        var file = this.repository.getFile(nameFile + ".jpg");

        content.setImage(file.getPath());

        return content;
    }
}
