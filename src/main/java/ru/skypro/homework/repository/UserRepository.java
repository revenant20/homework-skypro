package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.repository.entity.UserEn;

@Repository
public interface UserRepository extends JpaRepository<UserEn, Integer> {
    UserEn findByUsername(String username);
}
