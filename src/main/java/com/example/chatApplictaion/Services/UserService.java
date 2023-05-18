package com.example.chatApplictaion.Services;

import com.example.chatApplictaion.Repository.UserRepository;
import com.example.chatApplictaion.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public Optional<User> findUserByName(String name){
        return userRepository.findUserByName(name);
    }
}
