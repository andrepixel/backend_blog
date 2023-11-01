package com.andrepixel.backend_blog.configuration;

import com.andrepixel.backend_blog.dtos.ExceptionResponseCustomizedDTO;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchFileException.class)
    public ResponseEntity<ExceptionResponseCustomizedDTO> handleException(NoSuchFileException exception) {
        String message = "File not found";

        ExceptionResponseCustomizedDTO response =
                new ExceptionResponseCustomizedDTO(
                        HttpStatus.NOT_FOUND.value(),
                        message,
                        exception.getStackTrace()
                );

        return ResponseEntity
                .ok()
                .body(response);
    }
}
