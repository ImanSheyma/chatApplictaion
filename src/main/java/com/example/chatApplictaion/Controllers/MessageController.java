package com.example.chatApplictaion.Controllers;

import com.example.chatApplictaion.Exceptions.UserNotFoundException;
import com.example.chatApplictaion.Services.UserService;
import com.example.chatApplictaion.models.MessageModel;
import com.example.chatApplictaion.models.User;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class MessageController {
    private final UserService userService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{username}")
    public void sendMessage(@DestinationVariable String username, MessageModel message){
        Optional<User> user = userService.findUserByName(username);
        user.orElseThrow(()-> new UserNotFoundException(username));

        simpMessagingTemplate.convertAndSend("/topic/messages/" + username);
    }
}
