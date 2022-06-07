package ru.skypro.homework.dto.pass;

import lombok.Data;

@Data
public class ResetPasswordConfirm {
    private String uid;
    private String newPassword;
    private String token;
}
