package com.nugraha.restfulWebService.service

import com.nugraha.restfulWebService.dto.Message
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import  java.util.UUID

@Service
class MessageService(private val db: JdbcTemplate) {
    fun findMessages(): List<Message> = db.query("select * from messages") {
        response, _ -> Message(response.getString("id"), response.getString("text"))
    }

    fun save(message: Message): Message {
        val id = message.id ?: UUID.randomUUID().toString()
        db.update(
            "insert into messages value ( ?, ? )",
            id, message.text,
        )
        return message
    }
}