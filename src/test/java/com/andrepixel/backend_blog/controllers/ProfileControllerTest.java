package com.andrepixel.backend_blog.controllers;

import com.andrepixel.backend_blog.dtos.ProfileDTO;
import com.andrepixel.backend_blog.services.PhotoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PhotoService photoService;

    @Mock
    HttpURLConnection httpURLConnection;

    URL url;

    @BeforeEach
    void setUp() throws MalformedURLException {
        url = new URL("https://profile.jpg");
    }

    @Test
    public void getProfileImage() throws Exception {
        when(photoService.getProfileImage()).thenReturn(url);

        when(httpURLConnection.getInputStream()).thenReturn(new ByteArrayInputStream(new byte[0]));

        PowerMockito.whenNew(HttpURLConnection.class).withArguments(anyString()).thenReturn(httpURLConnection);

        mockMvc.perform(get("/profile/image"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_JPEG_VALUE));

        verify(photoService, times(1)).getProfileImage();
    }
}
