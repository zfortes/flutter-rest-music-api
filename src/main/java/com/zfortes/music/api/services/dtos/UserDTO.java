package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:44
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Playlist;
import com.zfortes.music.api.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

public class UserDTO {
    private Long id;

    @NotEmpty
    private String name;

    private String username;

    private List<Playlist> playlists;

    public UserDTO(Long id, String name, String username, List<Playlist> playlists) {
        this.id = id;
        this.playlists = playlists;
        this.name = name;
        this.username = username;
    }

    public UserDTO(User u) {
        this.id = u.getId();
        this.playlists = u.getPlaylists();
        this.name = u.getName();
        this.username = u.getUsername();
    }

    public User toUser() {
        return new User(
                this.id,
                this.name,
                this.username,
                this.playlists
        );
    }
}
