package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.AdsComment;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.dto.ResponseWrapper;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {

    @GetMapping()
    public ResponseWrapper<Ads> getALLAds() {
        return new ResponseWrapper<>();
    }

    @PostMapping()
    public Ads addAds() {
        return new Ads();
    }

    @GetMapping("me")
    public ResponseWrapper<Ads> getAdsMe() {
        return new ResponseWrapper<>();
    }

    @GetMapping("/{ad_pk}/comment")
    public ResponseWrapper<AdsComment> getAdsComments(@PathVariable("ad_pk") String adPk) {
        return new ResponseWrapper<>();
    }

    @PostMapping("/{ad_pk}/comment")
    public AdsComment addAdsComments(@PathVariable("ad_pk") String adPk,
                                     @RequestBody AdsComment comment) {
        return new AdsComment();
    }

    @GetMapping("/{ad_pk}/comment/{id}")
    public AdsComment getAdsComment(@PathVariable("ad_pk") String adPk,
                                    @PathVariable("id") Integer id) {
        return new AdsComment();
    }

    @PatchMapping("/{ad_pk}/comment/{id}")
    public AdsComment updateAdsComment(@PathVariable("ad_pk") String adPk,
                                       @PathVariable("id") Integer id,
                                       @RequestBody AdsComment comment) {
        return new AdsComment();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{ad_pk}/comment/{id}")
    public void deleteAdsComment(@PathVariable("ad_pk") String adPk,
                                 @PathVariable("id") Integer id) {
    }

    @GetMapping("/{id}")
    public FullAds getAds(@PathVariable("id") Integer id) {
        return new FullAds();
    }

    @PatchMapping("/{id}")
    public Ads updateAds(@PathVariable("id") Integer id,
                         @RequestBody Ads ads) {
        return new Ads();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void removeAds(@PathVariable("id") Integer id) {
    }

}

