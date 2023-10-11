package com.andrepixel.backend_blog.controllers

import PostDTO
import com.andrepixel.backend_blog.services.PostsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostsController {

    @Autowired
    val service = PostsService();

    @GetMapping(
            name = "posts",
            path = ["/posts"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAllPosts(): ResponseEntity<List<PostDTO>> {
        return ResponseEntity<List<PostDTO>>(
                this.service.getAllPosts(),
                HttpStatus.OK
        );
    }
}