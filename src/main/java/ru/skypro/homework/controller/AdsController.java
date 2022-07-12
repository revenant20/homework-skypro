package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.dto.ResponseWrapper;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.CommentService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {

    private final AdsService adsService;
    private final CommentService commentService;

    @GetMapping()
    public ResponseWrapper<Ads> getALLAds() {
        var response = new ResponseWrapper<Ads>();
        List<Ads> allAds = adsService.getAllAds();
        response.setResults(allAds);
        response.setCount(allAds.size());
        return response;
    }

    @PostMapping()
    public Ads addAds(@RequestBody CreateAds createAds, Authentication authentication) {
        return adsService.addAds(createAds, authentication.getName());
    }

    @GetMapping("me")
    public ResponseWrapper<Ads> getAdsMe(Authentication authentication) {
        var response = new ResponseWrapper<Ads>();
        List<Ads> allAds = adsService.getByEmail(authentication.getName());
        response.setResults(allAds);
        response.setCount(allAds.size());
        return response;
    }

    @GetMapping("/{id}")
    public FullAds getAds(@PathVariable("id") Integer id) {
        return adsService.getById(id);
    }

    @PatchMapping("/{id}")
    public Ads updateAds(@PathVariable("id") Integer id,
                         @RequestBody Ads ads) {
        return adsService.updateAds(id, ads);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void removeAds(@PathVariable("id") Integer id) {
    }

    @GetMapping("/{ad_pk}/comment")
    public ResponseWrapper<AdsComment> getAdsComments(@PathVariable("ad_pk") Integer adPk) {
        List<AdsComment> comments = commentService.getCommentsByAdsId(adPk);
        var response = new ResponseWrapper<AdsComment>();
        response.setResults(comments);
        return response;
    }

    @PostMapping("/{ad_pk}/comment")
    public AdsComment addAdsComments(@PathVariable("ad_pk") Integer adPk,
                                     @RequestBody AdsComment comment) {
        return commentService.addComment(comment, adPk);
    }

    @GetMapping("/{ad_pk}/comment/{id}")
    public AdsComment getAdsComment(@PathVariable("ad_pk") Integer adPk,
                                    @PathVariable("id") Integer id) {
        return commentService.getAdsComment(id, adPk);
    }

    @PatchMapping("/{ad_pk}/comment/{id}")
    public AdsComment updateAdsComment(@PathVariable("ad_pk") Integer adPk,
                                       @PathVariable("id") Integer id,
                                       @RequestBody AdsComment comment) {
        return commentService.updateAdsComment(id, adPk, comment);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{ad_pk}/comment/{id}")
    public void deleteAdsComment(@PathVariable("ad_pk") String adPk,
                                 @PathVariable("id") Integer id) {
        commentService.removeComment(adPk, id);
    }

}

