package com.nugraha.restfulWebService.repository

import com.nugraha.restfulWebService.dto.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>