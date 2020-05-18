package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:42
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class AlbumDTO {
    private Long id;

    @NotNull
    private String name;

    private String pictureUrl;

    public AlbumDTO(){}

    public AlbumDTO(Long id, String name, String pictureUrl){
        this.id = id;
        this.name = name;
        this.pictureUrl = pictureUrl;
    }

    public Album toAlbum(){
        Album album = new Album();
        album.setId(this.id);
        album.setPictureUrl(this.pictureUrl);
        album.setName(this.name);
        return album;
    }

}
