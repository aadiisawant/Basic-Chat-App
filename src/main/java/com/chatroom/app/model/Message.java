package com.chatroom.app.model;

public class Message {
	private String name;
    private String content;
    private String timestamp;
    public Message(String name, String content,String timestamp) {
        this.name = name;
        this.content = content;
        this.timestamp = timestamp;;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
    
}
