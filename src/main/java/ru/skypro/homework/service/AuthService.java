package ru.skypro.homework.service;

import ru.skypro.homework.dto.RegReq;
import ru.skypro.homework.dto.Role;

import java.util.Optional;

public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegReq regReq, Role role);
    Optional<String> changePassword(String userName, String password, String newPassword);
}
