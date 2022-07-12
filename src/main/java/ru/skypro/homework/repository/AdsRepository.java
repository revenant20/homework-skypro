package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.repository.entity.AdsEn;

import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<AdsEn, Integer> {
    List<AdsEn> findAllByEmail(String email);
}
