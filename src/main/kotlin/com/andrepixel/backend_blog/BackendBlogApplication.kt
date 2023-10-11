package com.andrepixel.backend_blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendBlogApplication {
	fun main(args: Array<String>) {
		runApplication<BackendBlogApplication>(*args)
	}
}