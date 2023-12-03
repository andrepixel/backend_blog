package com.andrepixel.backend_blog.datasources;

import com.andrepixel.backend_blog.repositories.IGetFilesRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component(value = "LocalPostsDatasource")
public class LocalPostsDatasource implements IGetFilesRepository {
    @Override
    public File getFiles() {
        return new File("assets/posts/");
    }
}
