package com.andrepixel.backend_blog.services;

import com.andrepixel.backend_blog.dtos.ContentDTO;
import com.andrepixel.backend_blog.repositories.IContentsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContentsPostsServiceTest {
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
                new ContentDTO("assets\\contents\\images\\posts\\post4.jpg");
    }

    @Test
    void shouldReturnContentImageFile() throws IOException {
        file = new File(contentDTO.getImage());

        when(repository.getFile("post4.jpg")).thenReturn(file);

        ContentDTO response = service.getContentProjectsImages("post4");

        assertNotNull(response);
        assertEquals(contentDTO.getImage(), response.getImage());

        verify(repository).getFile("post4.jpg");
        verifyNoMoreInteractions(repository);
    }
}