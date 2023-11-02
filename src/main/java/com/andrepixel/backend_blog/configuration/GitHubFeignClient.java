package com.andrepixel.backend_blog.configuration;

import com.andrepixel.backend_blog.dtos.GitHubDTO;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "github", url = "https://api.github.com")
public interface GitHubFeignClient {
    final String BEARER_TOKEN = "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";

    @GetMapping(
            value = "/users/andrepixel",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Headers(value = "Authorization: ${BEARER_TOKEN}")
    public GitHubDTO getProfile();
}
