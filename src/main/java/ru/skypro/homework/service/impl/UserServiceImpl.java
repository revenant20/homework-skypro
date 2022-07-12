package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.repository.entity.UserEn;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @PostConstruct
    public void init() {
        UserEn userEn = new UserEn();
        userEn.setPassword("password");
        userEn.setUsername("user@gmail.com");
        userEn.setPhone("123123123");
        userEn.setLastName("Ivanov");
        userEn.setFirstName("Ivan");
        repository.saveAndFlush(userEn);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll().stream()
                .map(this::getUser)
                .collect(Collectors.toList());
    }

    private User getUser(UserEn regReq) {
        User user = new User();
        user.setFirstName(regReq.getFirstName());
        user.setLastName(regReq.getLastName());
        user.setPhone(regReq.getPhone());
        user.setEmail(regReq.getUsername());
        user.setId(regReq.getId());
        return user;
    }

    @Override
    public User updateUser(User user) {
        UserEn entity = new UserEn();
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setPhone(user.getPhone());
        entity.setUsername(user.getEmail());
        entity.setId(user.getId());
        return getUser(repository.saveAndFlush(entity));
    }

    @Override
    public User getUserById(Integer userId) {
        return getUser(repository.getReferenceById(userId));
    }
}
