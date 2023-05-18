package com.example.chatApplictaion.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String username){
        super("user with name " + username + " not found");
    }
}
