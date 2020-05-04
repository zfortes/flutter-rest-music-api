package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:44
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Artist;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MusicDTO {
    private Long id;

    @NotNull
    private String name;

    private Album album;

    private List<Artist> artist;

    private String duration;

    private String pictureUrl;

    private String musicUrl;

    private String genre;
}
