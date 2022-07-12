package ru.skypro.homework.repository.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class AdsEn {
    @Id
    @GeneratedValue
    private Integer pk;

    @Lob
    private byte[] image;
    private Integer author;
    private String phone;
    private String email;
    private Integer price;
    private String title;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AdsEn adsEn = (AdsEn) o;
        return pk != null && Objects.equals(pk, adsEn.pk);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
