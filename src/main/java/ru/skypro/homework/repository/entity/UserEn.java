package ru.skypro.homework.repository.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class UserEn {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
