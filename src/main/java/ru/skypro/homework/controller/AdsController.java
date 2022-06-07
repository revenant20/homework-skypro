package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.AdsComment;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {

    @GetMapping()
    public String getALLAds() {
        return "asd";
    }

    @PostMapping()
    public String addAds() {
        return "asd";
    }

    @GetMapping("me")
    public String getAdsMe() {
        return "asd";
    }

    @GetMapping("/{ad_pk}/comment")
    public String getAdsComments(@PathVariable("ad_pk") String adPk) {
        return adPk;
    }

    @PostMapping("/{ad_pk}/comment")
    public String addAdsComments(@PathVariable("ad_pk") String adPk,
                                 @RequestBody AdsComment comment) {
        return adPk;
    }

    @GetMapping("/{ad_pk}/comment/{id}")
    public String getAdsComment(@PathVariable("ad_pk") String adPk,
                                @PathVariable("id") Integer id) {
        return adPk;
    }

    @PatchMapping("/{ad_pk}/comment/{id}")
    public String updateAdsComment(@PathVariable("ad_pk") String adPk,
                                   @PathVariable("id") Integer id,
                                   @RequestBody AdsComment comment) {
        return adPk;
    }

    @DeleteMapping("/{ad_pk}/comment/{id}")
    public String deleteAdsComment(@PathVariable("ad_pk") String adPk,
                                   @PathVariable("id") Integer id) {
        return adPk;
    }

    @GetMapping("/{id}")
    public String getAds(@PathVariable("id") Integer id) {
        return "asd";
    }

    @PatchMapping("/{id}")
    public String updateAds(@PathVariable("id") Integer id,
                            @RequestBody Ads ads){
        return "asd";
    }
    @DeleteMapping("/{id}")
    public String removeAds(@PathVariable("id") Integer id) {
        return "asd";
    }

}

