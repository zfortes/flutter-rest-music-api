package com.zfortes.music.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String pictureUrl;

    @ManyToMany
    private List<Artist> artist;

    @OneToMany
    private List<Music> musics;
}