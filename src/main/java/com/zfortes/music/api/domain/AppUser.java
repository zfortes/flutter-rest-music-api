package com.zfortes.music.api.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

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

    @Column(unique = true)
    private String username;

    @OneToMany(mappedBy = "appUser")
    private List<Playlist> playlists;

    public AppUser(Long id, @NotEmpty String name, @NotEmpty String username){
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public AppUser(Long id, String name, String username, List<Playlist> playlists){
        this.id = id;
        this.playlists = playlists;
        this.name = name;
        this.username = username;
    }

    public AppUser() {

    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }
}