package ru.skypro.homework.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapper<T> {
    private String next;
    private String previous;
    private Integer count;
    private List<T> results;
}
