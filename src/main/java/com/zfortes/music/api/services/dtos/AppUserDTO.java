package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:44
 * @project api
 * @author fortes
 */

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter

public class AppUserDTO {
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String username;

    private List<PlaylistDTO> playlists;

    public AppUserDTO(Long id, String name, String username, List<PlaylistDTO> playlists) {
        this.id = id;
        this.playlists = playlists;
        this.name = name;
        this.username = username;
    }

}
