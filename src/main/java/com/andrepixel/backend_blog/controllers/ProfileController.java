package com.andrepixel.backend_blog.controllers;

import com.andrepixel.backend_blog.dtos.ProfileDTO;
import com.andrepixel.backend_blog.services.PhotoService;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/profile/", path = "/profile/")
public class ProfileController {

  @Autowired
  PhotoService service;

  @GetMapping(value = "image", produces = MediaType.IMAGE_JPEG_VALUE)
  public ResponseEntity<InputStreamResource> getProfileImage()
    throws IOException {
    URL baseURL =  this.service.getProfileImage();

    InputStream inputStream = baseURL.openConnection().getInputStream();

    InputStreamResource inputStreamResource = new InputStreamResource(
      inputStream
    );

    return ResponseEntity
      .ok()
      .contentType(MediaType.IMAGE_JPEG)
      .body(inputStreamResource);
  }
}
