package com.zfortes.music.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @ManyToOne
    @NotNull
    private AppUser appUser;

    @OneToMany
    private List<Music> musics;

    public Playlist(){}

    public Playlist(Long id, String name, AppUser appUser, List<Music> musics){
        this.id = id;
        this.name = name;
        this.appUser = appUser;
        this.musics = musics;
    }

    public void addMusic(Music music){
        this.musics.add(music);
    }

    public void removeMusic(Music music) {
        this.musics.remove(music);
    }
}