package com.andrepixel.backend_blog.services

import PostDTO
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service
import java.io.File

@Service
class PostsService() {
    fun getAllPosts(): List<PostDTO> {
        val posts = emptyList<PostDTO>().toMutableList();

        val files = File("assets/posts/");

        for (file in files.listFiles()!!) {
            val post = jacksonObjectMapper().readValue<PostDTO>(file, PostDTO::class.java);

            posts.add(post);
        }

        return posts;
    }
}

fun main() {
    val service = PostsService();

    service.getAllPosts();
}