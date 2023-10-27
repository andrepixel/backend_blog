package com.andrepixel.backend_blog.repositories;

import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
public interface IContentsRepository {
    public File getFile(String nameFile);
}
