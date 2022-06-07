package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.pass.NewPassword;
import ru.skypro.homework.dto.pass.ResetPassword;
import ru.skypro.homework.dto.pass.ResetPasswordConfirm;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.dto.User;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping
    public String getALLUsers() {
        return "asd";
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        return "asd";
    }

    @GetMapping("/me")
    public String getUsers() {
        return "asd";
    }

    @PatchMapping("/me")
    public String updateUser(@RequestBody UpdateUser user) {
        return "asd";
    }

    @GetMapping("/{id}}")
    public String getUser(@PathVariable("id") Integer id) {
        return "asd";
    }

    @PostMapping("/reset_password")
    public String resetPassword(@RequestBody ResetPassword resetPassword) {
        return "asd";
    }

    @PostMapping("/reset_password_confirm")
    public String resetPasswordConfirm(@RequestBody ResetPasswordConfirm resetPasswordConfirm) {
        return "asd";
    }

    @PostMapping("/set_password")
    public String setPassword(@RequestBody NewPassword newPassword) {
        return "asd";
    }
}
