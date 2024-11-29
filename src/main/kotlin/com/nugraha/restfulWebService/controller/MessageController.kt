package com.nugraha.restfulWebService.controller

import com.nugraha.restfulWebService.dto.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {
    @GetMapping("/")
    fun listMessages() = listOf(
        Message("1", "hello"),
        Message("2", "bonjour"),
        Message("3", "privet"),
    )
}