package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdsComment;
import ru.skypro.homework.repository.entity.CommentEn;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    public final CommentRepository repository;

    @Override
    public List<AdsComment> getCommentsByAdsId(Integer adsId) {
        return repository.findAllByAdsPk(adsId).stream()
                .map(this::toAdsComment)
                .collect(Collectors.toList());
    }

    @Override
    public AdsComment addComment(AdsComment adsComment, Integer adsId) {
        CommentEn commentEn = toAdsCommentEn(adsComment, adsId);
        return toAdsComment(repository.saveAndFlush(commentEn));
    }

    @Override
    public AdsComment getAdsComment(Integer id, Integer adsId) {
        return toAdsComment(repository.findByPkAndAdsPk(id, adsId));
    }

    @Override
    public AdsComment updateAdsComment(Integer id, Integer adsId, AdsComment comment) {
        CommentEn byPkAndAdsPk = repository.findByPkAndAdsPk(id, adsId);
        if (byPkAndAdsPk == null) {
            return null;
        }
        CommentEn commentEn = toAdsCommentEn(comment, adsId);
        commentEn.setPk(byPkAndAdsPk.getPk());
        return toAdsComment(repository.saveAndFlush(commentEn));
    }

    @Override
    public void removeComment(String adPk, Integer id) {
        repository.deleteById(id);
    }

    private AdsComment toAdsComment(CommentEn tr) {
        AdsComment adsComment = new AdsComment();
        adsComment.setAuthor(tr.getAuthor());
        adsComment.setCreatedAt(tr.getCreatedAt());
        adsComment.setPk(tr.getPk());
        adsComment.setText(tr.getText());
        return adsComment;
    }

    private CommentEn toAdsCommentEn(AdsComment tr, Integer adsPk) {
        CommentEn en = new CommentEn();
        en.setAuthor(tr.getAuthor());
        en.setCreatedAt(tr.getCreatedAt());
        en.setPk(tr.getPk());
        en.setAdsPk(adsPk);
        en.setText(tr.getText());
        return en;
    }
}
