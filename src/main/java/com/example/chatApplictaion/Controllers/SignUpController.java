package com.example.chatApplictaion.Controllers;

import com.example.chatApplictaion.Repository.UserRepository;
import com.example.chatApplictaion.Requests.SignUpRequest;
import com.example.chatApplictaion.Responses.SignUpResponse;
import com.example.chatApplictaion.Services.UserService;
import com.example.chatApplictaion.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;

@RestController
@RequestMapping("/authentication")
@AllArgsConstructor
public class SignUpController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody
                                                 @Valid
                                                 SignUpRequest request){

        SignUpResponse response = SignUpResponse.builder()
                .user(userService.save(new User(request.getName(), request.getEmail(), request.getPassword())))
                .message("Sign up complete!")
                .timestamp(Instant.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SignUpResponse handlePasswordValidationException(MethodArgumentNotValidException e){
        return SignUpResponse.builder()
                .message(String.join(",", e.getBindingResult().getFieldError().getDefaultMessage()))
                .timestamp(Instant.now())
                .build();
    }
}
