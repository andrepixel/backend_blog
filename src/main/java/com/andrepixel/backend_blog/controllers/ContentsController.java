package com.andrepixel.backend_blog.controllers;

import com.andrepixel.backend_blog.dtos.ContentDTO;
import com.andrepixel.backend_blog.dtos.PostDTO;
import com.andrepixel.backend_blog.services.ContentsService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@Controller
@RequestMapping(name = "/contents/", path = "/contents/")
public class ContentsController {
    @Autowired
    ContentsService service = new ContentsService();

    @GetMapping(
            name = "images/posts", path = "images/posts",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @ResponseBody
    ResponseEntity getContentPostsImages(
            @RequestParam String id
    ) throws IOException {
        var contentDTO = this.service.getContentPostsImages(id);

        ByteArrayResource byteArrayResource =
                new ByteArrayResource(Files.readAllBytes(Path.of(contentDTO.getImage())));


        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(byteArrayResource);
    }
}
