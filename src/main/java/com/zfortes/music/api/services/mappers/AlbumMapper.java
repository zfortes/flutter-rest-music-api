package com.zfortes.music.api.services.mappers;/*
 * @created 08/05/2020 - 08:52
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.services.dtos.AlbumDTO;
import com.zfortes.music.api.services.dtos.ArtistDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumMapper {
    public static AlbumDTO toDto(Album u){
        List<ArtistDTO> artists =
                u.getArtists() == null ?
                        null :  u.getArtists().stream()
                        .map(ArtistMapper::toDto).collect(Collectors.toList());
        return new AlbumDTO(
                u.getId(),
                u.getName(),
                u.getPictureUrl(),
                artists);
    }

    public static Album toAlbum(AlbumDTO u) {
        List<Artist> artists =
                u.getArtists() == null ?
                        null :  u.getArtists().stream()
                        .map(ArtistMapper::toArtist).collect(Collectors.toList());
        return new Album(
                u.getId(),
                u.getName(),
                u.getPictureUrl(),
                artists);
    }
}