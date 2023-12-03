package com.andrepixel.backend_blog.datasources;

import com.andrepixel.backend_blog.repositories.IGetFilesRepository;
import org.springframework.stereotype.Component;

import java.io.File;

@Component(value = "LocalProjectsDatasource")
public class LocalProjectsDatasource implements IGetFilesRepository {
    @Override
    public File getFiles() {
        return new File("assets/projects/");
    }
}
