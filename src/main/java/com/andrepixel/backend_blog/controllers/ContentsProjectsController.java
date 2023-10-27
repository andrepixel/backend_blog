package com.andrepixel.backend_blog.controllers;

import com.andrepixel.backend_blog.dtos.ContentDTO;
import com.andrepixel.backend_blog.services.ContentsProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping(name = "/contents/", path = "/contents/")
public class ContentsProjectsController {
    @Autowired
    ContentsProjectsService service = new ContentsProjectsService();

    @GetMapping(
            name = "images/projects", path = "images/projects",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    ResponseEntity getContentProjectsImages(
            @RequestParam String id
    ) throws IOException {
        ContentDTO contentDTO = this.service.getContentProjectsImages(id);

        ByteArrayResource byteArrayResource =
                new ByteArrayResource(Files.readAllBytes(Path.of(contentDTO.getImage())));

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(byteArrayResource);
    }
}
