package com.andrepixel.backend_blog.datasources;

import com.andrepixel.backend_blog.repositories.IContentsRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;

@Component(value = "LocalFileProjectsDatasource")
public class LocalFileProjectsDatasource
        implements IContentsRepository {
    @Override
    public File getFile(String nameFile) {
        return new File("assets\\contents\\images\\projects\\" + nameFile);
    }
}
