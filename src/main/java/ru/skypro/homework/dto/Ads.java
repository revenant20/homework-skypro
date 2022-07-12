package ru.skypro.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.skypro.homework.repository.entity.AdsEn;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ads {
    private String image;
    private Integer price;
    private Integer author;
    private Integer pk;
    private String title;

    public static Ads fromEn(AdsEn ads) {
        return Ads.builder()
                //.image(ads.getImage())
                .price(ads.getPrice())
                .title(ads.getTitle())
                .pk(ads.getPk())
                .author(ads.getAuthor())
                .build();
    }
}
