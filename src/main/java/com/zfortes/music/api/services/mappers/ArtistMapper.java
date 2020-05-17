package com.zfortes.music.api.services.mappers;/*
 * @created 08/05/2020 - 08:52
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.services.dtos.ArtistDTO;

public class ArtistMapper {
    public static ArtistDTO toDto(Artist u){
        return new ArtistDTO(u.getId(), u.getName(), u.getPictureUrl(), u.getAlbums());
    }
}