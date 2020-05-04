package com.zfortes.music.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Album album;

    @OneToMany
    private List<Artist> artist;

    private String duration;

    private String pictureUrl;

    private String genre;
}