package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.ContentDTO;
import com.andrepixel.backend_blog.repositories.IContentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ContentsProjectsService {

    @Autowired
    @Qualifier(value = "LocalFileProjectsDatasource")
    IContentsRepository repository;

    public ContentDTO getContentProjectsImages(String nameFile) throws IOException {
        ContentDTO content = new ContentDTO();

        File file = this.repository.getFile(nameFile + ".jpg");

        content.setImage(file.getPath());

        return content;
    }
}
