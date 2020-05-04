package com.zfortes.music.api.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String pictureUrl;

    @ManyToMany
    private List<Album> albums;
}