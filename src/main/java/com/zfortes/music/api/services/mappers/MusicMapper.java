package com.zfortes.music.api.services.mappers;/*
 * @created 17/05/2020 - 19:27
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Music;
import com.zfortes.music.api.services.dtos.AlbumDTO;
import com.zfortes.music.api.services.dtos.ArtistDTO;
import com.zfortes.music.api.services.dtos.MusicDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MusicMapper {
    public static MusicDTO toDto(Music u){
        AlbumDTO albumDTO = u.getAlbum() !=  null ? AlbumMapper.toDto(u.getAlbum()) : null;
        return new MusicDTO(
                u.getId(),
                u.getName(),
                albumDTO,
                u.getDuration(),
                u.getPictureUrl(),
                u.getMusicUrl(),
                u.getGenre()
                );
    }
}
