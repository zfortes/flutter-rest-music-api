package com.zfortes.music.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Getter
@Setter
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String username;

    @OneToMany(mappedBy = "appUser")
    private List<Playlist> playlists;

    public AppUser(){}

    public AppUser(Long id, String name, String username, List<Playlist> playlists){
        this.id = id;
        this.playlists = playlists;
        this.name = name;
        this.username = username;
    }
}