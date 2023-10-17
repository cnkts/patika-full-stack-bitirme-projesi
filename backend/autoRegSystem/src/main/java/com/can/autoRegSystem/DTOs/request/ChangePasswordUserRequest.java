package com.can.autoRegSystem.DTOs.request;

import lombok.Data;

@Data
public class ChangePasswordUserRequest {
    private String oldPassword;
    private String newPassword;
}
