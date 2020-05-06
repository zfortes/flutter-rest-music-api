package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:44
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Music;
import com.zfortes.music.api.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

public class PlaylistDTO {
    private Long id;

    @NotNull
    private String name;

    private User user;

    private List<Music> musics;
}
