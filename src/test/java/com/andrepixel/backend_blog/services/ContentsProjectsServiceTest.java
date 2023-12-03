package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.ContentDTO;
import com.andrepixel.backend_blog.repositories.IContentsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
class ContentsProjectsServiceTest {
    @Mock
    IContentsRepository repository;

    @Mock
    File file;

    @InjectMocks
    ContentsProjectsService service;

    ContentDTO contentDTO;

    @BeforeEach
    void setUp() {
        contentDTO =
                new ContentDTO("assets\\contents\\images\\projects\\project3" +
                                       ".jpg");
    }

    @Test
    void shouldReturnContentImageFile() throws IOException {
        file = new File(contentDTO.getImage());

        when(repository.getFile("project3.jpg")).thenReturn(file);

        ContentDTO response = service.getContentProjectsImages("project3");

        assertNotNull(response);
        assertEquals(contentDTO.getImage(), response.getImage());

        verify(repository).getFile("project3.jpg");
        verifyNoMoreInteractions(repository);
    }
}