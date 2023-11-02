package com.andrepixel.backend_blog.datasources;

import com.andrepixel.backend_blog.configuration.GitHubFeignClient;
import com.andrepixel.backend_blog.dtos.GitHubDTO;
import com.andrepixel.backend_blog.repositories.IProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GitHubDatasource implements IProfileRepository {

    @Autowired
    private GitHubFeignClient client;

    @Override
    public String getImageProfile() {
        GitHubDTO profile = this.client.getProfile();

        return profile.getAvatar_url();
    }
}
