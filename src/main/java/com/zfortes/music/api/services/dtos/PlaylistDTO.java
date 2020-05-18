package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:44
 * @project api
 * @author fortes
 */

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

public class PlaylistDTO {
    private Long id;

    @NotNull
    private String name;

    private AppUserDTO appUser;

    private List<MusicDTO> musics;

    public PlaylistDTO(){}

    public PlaylistDTO(Long id, String name, AppUserDTO appUser, List<MusicDTO> musics){
        this.id = id;
        this.name = name;
        this.appUser = appUser;
        this.musics = musics;
    }
}
