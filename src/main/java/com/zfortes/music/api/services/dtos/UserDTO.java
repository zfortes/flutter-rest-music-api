package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:44
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Playlist;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserDTO {
    private Long id;

    @NotNull
    private String name;

    private String username;

    private List<Playlist> playlists;
}
