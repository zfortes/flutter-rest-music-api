package com.zfortes.music.api.services.mappers;/*
 * @created 08/05/2020 - 08:52
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.services.dtos.AlbumDTO;

public class AlbumMapper {
    public static AlbumDTO toDto(Album u){
        return new AlbumDTO(u.getId(), u.getName(), u.getPictureUrl());
    }
}