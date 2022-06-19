package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.FullAds;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsServiceImpl implements AdsService {

    private final List<FullAds> adsList = new ArrayList<>();

    @Override
    public List<Ads> getAllAds() {
        return adsList.stream()
                .map(Ads::fromFull)
                .collect(Collectors.toList());
    }

    @Override
    public Ads addAds(CreateAds ads, String email) {
        FullAds fullAds = FullAds.builder()
                .email(email)
                .image(ads.getImage())
                .price(ads.getPrice())
                .title(ads.getTitle())
                .description(ads.getDescription())
                .pk(ads.getPk())
                .build();
        adsList.add(fullAds);
        return Ads.fromFull(fullAds);
    }

    @Override
    public List<Ads> getByEmail(String email) {
        return adsList.stream()
                .filter(t -> t.getEmail().equals(email))
                .map(Ads::fromFull)
                .collect(Collectors.toList());
    }
}
