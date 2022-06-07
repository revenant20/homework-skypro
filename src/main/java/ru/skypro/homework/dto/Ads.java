package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class Ads {
    private String image;
    private Integer price;
    private Integer author;
    private Integer pk;
    private String title;
}
