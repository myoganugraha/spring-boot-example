package com.nugraha.restfulWebService.service

import com.nugraha.restfulWebService.dto.Message
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class MessageService(private val db: JdbcTemplate) {
    fun findMessages(): List<Message> = db.query("select * from messages") {
        response, _ -> Message(response.getString("id"), response.getString("text"))
    }

    fun save(message: Message): Message {
        db.update(
            "insert into messages value ( ?, ? )",
            message.id, message.text,
        )
        return message
    }
}