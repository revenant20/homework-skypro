package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.CreateUser;
import ru.skypro.homework.dto.ResponseWrapper;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.dto.pass.NewPassword;
import ru.skypro.homework.dto.pass.ResetPassword;
import ru.skypro.homework.dto.pass.ResetPasswordConfirm;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @PostMapping
    public CreateUser addUser(@RequestBody CreateUser user) {
        return new CreateUser();
    }

    @GetMapping("/me")
    public ResponseWrapper<User> getUsers() {
        return new ResponseWrapper<>();
    }

    @PatchMapping("/me")
    public User updateUser(@RequestBody User user) {
        return new User();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return new User();
    }

    @PostMapping("/reset_password")
    public ResetPassword resetPassword(@RequestBody ResetPassword resetPassword) {
        return new ResetPassword();
    }

    @PostMapping("/reset_password_confirm")
    public ResetPasswordConfirm resetPasswordConfirm(@RequestBody ResetPasswordConfirm resetPasswordConfirm) {
        return new ResetPasswordConfirm();
    }

    @PostMapping("/set_password")
    public NewPassword setPassword(@RequestBody NewPassword newPassword) {
        return new NewPassword();
    }
}
