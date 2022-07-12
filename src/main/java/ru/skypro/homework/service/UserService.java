package ru.skypro.homework.service;

import ru.skypro.homework.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User updateUser(User user);
    User getUserById(Integer userId);
}
