package ru.skypro.homework.service;

import ru.skypro.homework.dto.AdsComment;

import java.util.List;

public interface CommentService {
    List<AdsComment> getCommentsByAdsId(Integer adsId);
    AdsComment addComment(AdsComment adsComment, Integer adsId);
    AdsComment getAdsComment(Integer id, Integer adsId);
    AdsComment updateAdsComment(Integer id, Integer adsId, AdsComment comment);
    void removeComment(String adPk, Integer id);
}
