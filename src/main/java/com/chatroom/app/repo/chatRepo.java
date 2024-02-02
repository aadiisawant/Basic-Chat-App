package com.chatroom.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatroom.app.model.Message;

@Repository
public interface chatRepo extends JpaRepository<Message, Long> {

}
