package com.zfortes.music.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String pictureUrl;

    @ManyToMany
    private List<Artist> artists;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Music> musics;

    public Album(){}

    public Album(Long id, String name, String pictureUrl, List<Artist> artists) {
        this.id =id;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.artists = artists;
    }
}