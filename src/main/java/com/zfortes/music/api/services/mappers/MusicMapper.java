package com.zfortes.music.api.services.mappers;/*
 * @created 17/05/2020 - 19:27
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Music;
import com.zfortes.music.api.services.dtos.AlbumDTO;
import com.zfortes.music.api.services.dtos.MusicDTO;

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

    public static Music toMusic(MusicDTO u){
        Album album = u.getAlbum() !=  null ? AlbumMapper.toAlbum(u.getAlbum()) : null;
        return new Music(
                u.getId(),
                u.getName(),
                album,
                u.getDuration(),
                u.getPictureUrl(),
                u.getMusicUrl(),
                u.getGenre()
        );
    }
}
