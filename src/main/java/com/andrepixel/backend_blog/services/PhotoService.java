package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.ProfileDTO;
import com.andrepixel.backend_blog.repositories.IProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    @Qualifier(
            "gitHubDatasource"
    )
    @Autowired
    IProfileRepository repository;

    public ProfileDTO getProfileImage() {
        ProfileDTO profileDTO = new ProfileDTO(this.repository.getImageProfile());

        return profileDTO;
    }
}

