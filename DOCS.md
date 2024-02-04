# Chat Application Documentation

## Introduction
This document provides documentation for the Chat Application, a Spring Boot project. The application allows users to enter a chat room, send messages, and view chat history.

## Usage
1. **Run Locally:**
   - Clone the project repository to your local machine:
     ```
     git clone https://github.com/aadiisawant/Basic-Chat-App.git
     ```

   - Open the project in your preferred IDE (like IntelliJ IDEA or Eclipse).
   - Create the database with name chartroom in MySql.
   - Change the username and password as required in application.properties file to access locally. 
   - Run the `ChatApplication` class, which contains the `main` method, to start the Spring Boot application.

2. **Access the Chat Application:**
   - Open a web browser and navigate to [http://localhost:9090](http://localhost:9090).

3. **Enter the Chat Room:**
   - Enter your name and click on the "Enter" button.

4. **Send Messages:**
   - Once inside the chat room, type your message in the input field.
   - Click the "Send" button to send the message to the chat room.

5. **View Chat History:**
   - Click the "Show History" button to fetch and display chat history.
   - The chat history will be shown below the input field.

6. **Delete Chat History:**
   - Click the "Delete History" button to delete the chat history.
   - This action will remove all previous messages from the chat history.

7. **Logout:**
   - Click the "Logout" button to exit the chat room.
   - You can re-enter the chat room later by providing your name again.

## Features
- Real-time chat using WebSocket (STOMP and SockJS).
- Dynamic display of messages without page refresh.
- Chat history storage on the server.
- Ability to show and delete chat history.
- Simple and user-friendly interface.

## Dependencies
- Bootstrap: [Link to Bootstrap](https://getbootstrap.com/)
- jQuery: [Link to jQuery](https://jquery.com/)
- SockJS: [Link to SockJS](https://github.com/sockjs/sockjs-client)
- STOMP: [Link to STOMP](https://github.com/stomp-js/stompjs)

## Authors
- Aditya Chandrakant Sawant


