package com.can.autoRegSystem.DTOs.response;

import lombok.Data;

@Data
public class AuthResponse {
    String message;
    int userId;
    String userName;

}
