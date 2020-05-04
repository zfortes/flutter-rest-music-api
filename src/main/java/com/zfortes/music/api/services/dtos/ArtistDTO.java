package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:43
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ArtistDTO {
    private Long id;

    @NotNull
    private String name;

    private String pictureUrl;

    private List<Album> albums;
}
