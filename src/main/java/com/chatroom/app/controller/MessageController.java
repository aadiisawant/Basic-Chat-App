package com.chatroom.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatroom.app.model.Message;
import com.chatroom.app.repo.chatRepo;
import com.chatroom.app.service.ChatHistoryCheck;

@RestController
@RequestMapping("chathistory")
public class MessageController {

	@Autowired
	ChatHistoryCheck chatHistoryCheck;
	
	@MessageMapping("/message")
    @SendTo("/topic/return-to")
    public Message getContent(@RequestBody Message message) {
		
		chatHistoryCheck.addChat(message);
		System.out.println(message.getName()+" "+message.getContent()+" "+message.getTimestamp());
        return message;
    }
	
	@GetMapping("/getchat")
	public List<Message> getChatHistory(){
		
		return chatHistoryCheck.allcharts();
	}
	
    
     @DeleteMapping("/deletechat")
     public String deleteChat(){
    	 
      	chatHistoryCheck.deleteChat();
      	return "chartDeleted";
      
     }
     
}
