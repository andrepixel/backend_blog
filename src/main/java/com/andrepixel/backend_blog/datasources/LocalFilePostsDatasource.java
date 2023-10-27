package com.andrepixel.backend_blog.datasources;

import com.andrepixel.backend_blog.repositories.IContentsRepository;
import org.springframework.stereotype.Component;

import java.io.File;

@Component(value = "LocalFilePostsDatasource")
public class LocalFilePostsDatasource implements IContentsRepository {
    @Override
    public File getFile(String nameFile) {
        return new File("assets\\contents\\images\\posts\\" + nameFile);
    }
}
