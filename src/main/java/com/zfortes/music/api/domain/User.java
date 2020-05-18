package com.zfortes.music.api.domain;

import com.zfortes.music.api.services.dtos.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "userapi")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String username;

    @OneToMany
    private List<Playlist> playlists;

    public User(Long id, String name, String username, List<Playlist> playlists){
        this.id = id;
        this.playlists = playlists;
        this.name = name;
        this.username = username;
    }

    public UserDTO toDto() {
        return new UserDTO(
            this.id,
            this.name,
            this.username,
            this.playlists
        );
    }
}