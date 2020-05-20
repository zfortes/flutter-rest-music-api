package com.zfortes.music.api.services.mappers;/*
 * @created 08/05/2020 - 08:52
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.AppUser;
import com.zfortes.music.api.domain.Music;
import com.zfortes.music.api.domain.Playlist;
import com.zfortes.music.api.services.dtos.AppUserDTO;
import com.zfortes.music.api.services.dtos.MusicDTO;
import com.zfortes.music.api.services.dtos.PlaylistDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PlaylistMapper {
    public static PlaylistDTO toDto(Playlist u){
        List<MusicDTO> musics =
                u.getMusics() == null ?
                        new LinkedList<>() :  u.getMusics().stream().map(MusicMapper::toDto).collect(Collectors.toList());
        AppUserDTO appUserDto = AppUserMapper.toDto( u.getAppUser() == null ? new AppUser() : u.getAppUser());
        return new PlaylistDTO(
                u.getId(),
                u.getName(),
                appUserDto,
                musics);
    }

    public static Playlist toPlaylist(PlaylistDTO u){
        List<Music> musics =
                u.getMusics() == null ?
                        new LinkedList<>() :  u.getMusics().stream()
                        .map(MusicMapper::toMusic).collect(Collectors.toList());
        AppUser appUserDto = AppUserMapper.toAppUser(u.getAppUser());
        return new Playlist(
                u.getId(),
                u.getName(),
                appUserDto,
                musics);
    }
}