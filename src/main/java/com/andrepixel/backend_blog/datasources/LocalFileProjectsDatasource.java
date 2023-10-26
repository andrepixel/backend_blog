package com.andrepixel.backend_blog.datasources;

import com.andrepixel.backend_blog.repositories.IContentsRepository;

import java.io.File;

public class LocalFileProjectsDatasource implements IContentsRepository {
    @Override
    public File getFile(String nameFile) {
        return new File("assets/contents/images/projects/" + nameFile);
    }
}
