package com.zfortes.music.api.services.mappers;/*
 * @created 17/05/2020 - 19:27
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.domain.Music;
import com.zfortes.music.api.services.dtos.ArtistDTO;
import com.zfortes.music.api.services.dtos.MusicDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MusicMapper {
    public static MusicDTO toDto(Music u){
        return new MusicDTO(
                u.getId(),
                u.getName(),
                u.getAlbum() !=  null ? u.getAlbum().toDto() : null,
                u.getDuration(),
                u.getPictureUrl(),
                u.getMusicUrl(),
                u.getGenre()
                );
    }
}
