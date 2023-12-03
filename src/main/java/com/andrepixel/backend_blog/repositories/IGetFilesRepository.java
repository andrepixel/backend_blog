package com.andrepixel.backend_blog.repositories;

import com.andrepixel.backend_blog.dtos.PostDTO;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;

@Repository
public interface IGetFilesRepository {
    public File getFiles();
}
