package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.ProfileDTO;
import com.andrepixel.backend_blog.repositories.IProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class PhotoService {
    @Qualifier(
            "gitHubDatasource"
    )
    @Autowired
    IProfileRepository repository;

    public URL getProfileImage() throws MalformedURLException {
        URL url = new URL(this.repository.getImageProfile());

        return url;
    }
}

