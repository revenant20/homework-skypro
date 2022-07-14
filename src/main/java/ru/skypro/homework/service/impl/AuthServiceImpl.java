package ru.skypro.homework.service.impl;


import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.RegReq;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.repository.entity.UserEn;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AuthService;

import java.util.Optional;

@Service
public class AuthServiceImpl  {
/*
    private final UserDetailsManager manager;

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public AuthServiceImpl(UserDetailsManager manager, UserRepository userRepository) {
        this.manager = manager;
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean login(String userName, String password) {
        if (!manager.userExists(userName)) {
            return false;
        }
        UserDetails userDetails = manager.loadUserByUsername(userName);
        String encryptedPassword = userDetails.getPassword();
        String encryptedPasswordWithoutEncryptionType = encryptedPassword.substring(8);
        return encoder.matches(password, encryptedPasswordWithoutEncryptionType);
    }

    @Override
    public Optional<String> changePassword(String userName, String password, String newPassword) {
        if (!manager.userExists(userName)) {
            return Optional.empty();
        }
        UserDetails userDetails = manager.loadUserByUsername(userName);
        String encryptedPassword = userDetails.getPassword();
        String encryptedPasswordWithoutEncryptionType = encryptedPassword.substring(8);
        System.out.println("PASS" + password);
        System.out.println("OLD PASS" + encryptedPasswordWithoutEncryptionType);
        if (!encoder.matches(password, encryptedPasswordWithoutEncryptionType)) {
            return Optional.empty();
        }
        manager.changePassword(password, newPassword);
        UserEn byUsername = userRepository.findByUsername(userName);
        byUsername.setPassword(newPassword);
        UserEn userEn = userRepository.saveAndFlush(byUsername);
        return Optional.ofNullable(userEn.getPassword());
    }

    @Override
    public boolean register(RegReq regReq, Role role) {
        if (manager.userExists(regReq.getUsername())) {
            return false;
        }
        UserEn entity = new UserEn();
        entity.setFirstName(regReq.getFirstName());
        entity.setLastName(regReq.getLastName());
        entity.setPhone(regReq.getPhone());
        entity.setUsername(regReq.getUsername());
        entity.setPassword(regReq.getPassword());
        userRepository.saveAndFlush(entity);
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .password(regReq.getPassword())
                        .username(regReq.getUsername())
                        .roles(role.name())
                        .build()
        );
        return true;
    }*/
}
