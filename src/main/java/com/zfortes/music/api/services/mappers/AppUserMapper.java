package com.zfortes.music.api.services.mappers;/*
 * @created 08/05/2020 - 08:52
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.AppUser;
import com.zfortes.music.api.domain.Playlist;
import com.zfortes.music.api.services.dtos.AppUserDTO;
import com.zfortes.music.api.services.dtos.PlaylistDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AppUserMapper {
    public static AppUserDTO toDto(AppUser u){
        return new AppUserDTO(u.getId(), u.getName(), u.getUsername());
    }

    public static AppUser toAppUser(AppUserDTO u){
        return new AppUser(u.getId(), u.getName(), u.getUsername());
    }
}
