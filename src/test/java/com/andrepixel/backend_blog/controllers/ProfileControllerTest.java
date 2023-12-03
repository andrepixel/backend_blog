package com.andrepixel.backend_blog.controllers;

import com.andrepixel.backend_blog.dtos.ProfileDTO;
import com.andrepixel.backend_blog.services.PhotoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProfileController.class)
class ProfileControllerTest {
    @MockBean
    PhotoService service;

    @Spy
    URL url;

    @Mock
    HttpURLConnection httpURLConnection;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws MalformedURLException {
//        url = new URL("http://www.asudhaosuidhaosdhi.com.br/");
    }

    @Test
    public void shouldReturnProfileImage() throws Exception {
        byte[] mockByte = "image".getBytes();
        InputStream inputStream = new ByteArrayInputStream(mockByte);

        when(url.openConnection()).thenReturn(httpURLConnection);
        when(httpURLConnection.getResponseCode()).thenReturn(HttpStatus.OK.value());
        when(service.getProfileImage()).thenReturn(new ProfileDTO("http://www.asudhaosuidhaosdhi.com.br/"));

        mockMvc.perform(get("/profile/image"))
               .andExpect(status().isOk())
               .andExpect(content().bytes(mockByte));

    }
}