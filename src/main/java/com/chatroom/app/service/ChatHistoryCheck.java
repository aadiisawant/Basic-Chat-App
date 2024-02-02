package com.chatroom.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatroom.app.model.Message;
import com.chatroom.app.repo.chatRepo;

@Service
public class ChatHistoryCheck {

	@Autowired
	chatRepo chatDao;

	public void addChat(Message message) {
		chatDao.save(message);
	}
	
	public void deleteChat() {
		chatDao.deleteAll();
	}
	public List<Message> allcharts(){
		return chatDao.findAll();
	}
}
