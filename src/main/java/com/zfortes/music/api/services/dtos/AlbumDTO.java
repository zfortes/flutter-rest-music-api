package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:42
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.domain.Music;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlbumDTO {
    private Long id;

    @NotNull
    private String name;

    private String pictureUrl;

    private List<Artist> artist;

    private List<Music> musics;
}
