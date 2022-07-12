package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.repository.entity.AdsEn;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.entity.UserEn;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {

    private AdsRepository repository;

    private UserRepository userRepository;

    @Override
    public List<Ads> getAllAds() {
        return repository.findAll()
                .stream()
                .map(Ads::fromEn)
                .collect(Collectors.toList());
    }

    @Override
    public Ads addAds(CreateAds ads, String email) {
        AdsEn adsEn = new AdsEn();
        adsEn.setEmail(email);
        //adsEn.setImage(ads.getImage());
        adsEn.setPrice(ads.getPrice());
        adsEn.setTitle(ads.getTitle());
        adsEn.setDescription(ads.getDescription());
        adsEn.setPk(ads.getPk());
        UserEn byUsername = userRepository.findByUsername(email);
        adsEn.setAuthor(byUsername.getId());
        adsEn.setPhone(byUsername.getPhone());
        return Ads.fromEn(repository.saveAndFlush(adsEn));
    }

    @Override
    public List<Ads> getByEmail(String email) {
        return repository.findAllByEmail(email).stream()
                .map(Ads::fromEn)
                .collect(Collectors.toList());
    }

    @Override
    public FullAds getById(Integer id) {
        return fromEn(repository.getReferenceById(id));
    }

    @Override
    public Ads updateAds(Integer id, Ads ads) {
        AdsEn adsEn = repository.getReferenceById(id);
        //fullAds.setImage(ads.getImage());
        adsEn.setPrice(ads.getPrice());
        adsEn.setTitle(ads.getTitle());
        adsEn.setPk(ads.getPk());
        return Ads.fromEn(adsEn);
    }

    private FullAds fromEn(AdsEn ads) {
        UserEn referenceById = userRepository.getReferenceById(ads.getAuthor());
        return FullAds.builder()
                .authorFirstName(referenceById.getFirstName())
                //.image(ads.getImage())
                .authorLastName(referenceById.getLastName())
                .phone(ads.getPhone())
                .email(ads.getEmail())
                .price(ads.getPrice())
                .pk(ads.getPk())
                .title(ads.getTitle())
                .description(ads.getDescription())
                .build();
    }

}
