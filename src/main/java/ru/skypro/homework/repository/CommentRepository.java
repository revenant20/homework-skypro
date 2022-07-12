package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.repository.entity.CommentEn;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEn, Integer> {
    List<CommentEn> findAllByAdsPk(Integer pk);

    CommentEn findByPkAndAdsPk(Integer pk, Integer adsPk);
}
