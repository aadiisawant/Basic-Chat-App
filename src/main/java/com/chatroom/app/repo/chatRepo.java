package com.chatroom.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatroom.app.model.chatHistory;

public interface chatRepo extends JpaRepository<chatHistory, Long> {

}
