package ru.skypro.homework.repository.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CommentEn {
    @Id
    @GeneratedValue
    private Integer pk;
    private Integer author;
    private Date createdAt;
    private Integer adsPk;
    private String text;
}
