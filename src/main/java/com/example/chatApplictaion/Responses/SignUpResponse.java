package com.example.chatApplictaion.Responses;

import com.example.chatApplictaion.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpResponse {
    private String message;
    private Instant timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;
}
