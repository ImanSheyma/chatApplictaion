package com.example.chatApplictaion.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    @Email
    private String email;
    private String name;
    private String password;
}
