package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.RegReq;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.repository.entity.UserEn;
import ru.skypro.homework.service.AuthService;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceCustomImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public boolean checkUser(HttpHeaders headers) {
        List<String> authorization = headers.get("Authorization");
        System.out.println("authorization");
        System.out.println(authorization);
        String s = authorization.get(0);
        String[] s2 = s.split(" ");
        byte[] decode;
        try {
             decode = Base64.getDecoder().decode(s2[1].trim().getBytes(StandardCharsets.UTF_8));
        } catch (IllegalArgumentException e) {
            decode = (s2[1] + ":" + s2[2]).getBytes(StandardCharsets.UTF_8);
        }
        String s1 = new String(decode);
        System.out.println(s1);
        String[] split = s1.split(":");
        if (!userRepository.existsByUsername(split[0])) {
            return false;
        }
        UserEn byUsername = userRepository.findByUsername(split[0]);
        return byUsername.getPassword().equals(split[1]);
    }

    @Override
    public boolean login(String userName, String password) {
        if (!userRepository.existsByUsername(userName)) {
            return false;
        }
        UserEn byUsername = userRepository.findByUsername(userName);
        return byUsername.getPassword().equals(password);
    }

    @Override
    public boolean register(RegReq regReq, Role role) {
        if (userRepository.existsByUsername(regReq.getUsername())) {
            System.out.println(regReq.getUsername() + "exists");
            return false;
        }
        UserEn entity = new UserEn();
        entity.setFirstName(regReq.getFirstName());
        entity.setLastName(regReq.getLastName());
        entity.setPhone(regReq.getPhone());
        entity.setUsername(regReq.getUsername());
        entity.setPassword(regReq.getPassword());
        userRepository.saveAndFlush(entity);
        return true;
    }

    @Override
    public Optional<String> changePassword(String userName, String password, String newPassword) {
        if (!userRepository.existsByUsername(userName)) {
            return Optional.empty();
        }
        UserEn user = userRepository.findByUsername(userName);
        if (!user.getPassword().equals(password)) {
            return Optional.empty();
        }
        user.setPassword(newPassword);
        UserEn savedUser = userRepository.saveAndFlush(user);
        return Optional.ofNullable(savedUser.getPassword());
    }
}
