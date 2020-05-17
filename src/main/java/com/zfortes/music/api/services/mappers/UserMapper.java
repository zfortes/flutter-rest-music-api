package com.zfortes.music.api.services.mappers;/*
 * @created 08/05/2020 - 08:52
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.User;
import com.zfortes.music.api.services.dtos.UserDTO;

public class UserMapper {
    public static UserDTO toDto(User u){
        return new UserDTO(u);
    }
}
