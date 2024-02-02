package com.chatroom.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatroom.app.model.Message;
import com.chatroom.app.repo.chatRepo;

@RestController
public class MessageController {

	@Autowired
	private chatRepo chatRepo;
	
	@MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message getContent(@RequestBody Message message) {
		
		System.out.println(message.getName()+" "+message.getContent()+" "+message.getTimestamp());

        return message;
    }
}
