package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.ResponseWrapper;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.service.AuthService;
import ru.skypro.homework.service.UserService;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @GetMapping("/me")
    public ResponseEntity<ResponseWrapper<User>> getUsers(@RequestHeader HttpHeaders headers) {
        if (!authService.checkUser(headers)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        List<User> allUsers = userService.getAllUsers();
        var userResponseWrapper = new ResponseWrapper<User>();
        userResponseWrapper.setResults(allUsers);
        return ResponseEntity.ok(userResponseWrapper);
    }

    @PatchMapping("/me")
    public ResponseEntity<User> updateUser(@RequestHeader HttpHeaders headers, @RequestBody User user) {
        if (!authService.checkUser(headers)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

   /* @PostMapping("/set_password")
    public NewPassword setPassword(@RequestBody NewPassword newPassword, Authentication authentication) {
        NewPassword resultPassword = new NewPassword();
        authService.changePassword(
                        authentication.getName(),
                        newPassword.getCurrentPassword(),
                        newPassword.getNewPassword()
                )
                .ifPresent(resultPassword::setCurrentPassword);
        return resultPassword;
    }*/
}
