package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class ReqReq {
    private String password;
    private String username;
    private Role role;
}
