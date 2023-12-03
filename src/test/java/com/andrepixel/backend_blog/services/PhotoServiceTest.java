package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.ProfileDTO;
import com.andrepixel.backend_blog.repositories.IProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PhotoServiceTest {

    @Mock
    IProfileRepository repository;

    @InjectMocks
    PhotoService service;

    ProfileDTO profileDTO;

    @BeforeEach
    public void setUp() {
        profileDTO = new ProfileDTO(
                "http://github.com/andrepixel/aosuidhaoweubfrqowiutb.jpg");
    }

    @Test
    public void shouldReturnPathProfileImage() {
        Mockito.when(this.repository.getImageProfile())
               .thenReturn(profileDTO.getProfileImage());

        ProfileDTO profileImage = this.service.getProfileImage();

        assertNotNull(profileImage.getProfileImage());
    }

    @Test
    public void shouldReturnEmptyPathProfileImage() {
        Mockito.when(this.repository.getImageProfile())
               .thenReturn("");

        ProfileDTO profileImage = this.service.getProfileImage();

        assertNotNull(profileImage.getProfileImage());
    }
}