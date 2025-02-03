package com.vinsguru.entity;

import com.vinsguru.domain.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    private Integer id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre favoriteGenre;

}
