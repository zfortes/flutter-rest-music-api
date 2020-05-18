package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:42
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

public class AlbumDTO {
    private Long id;

    @NotNull
    private String name;

    private String pictureUrl;

    private List<ArtistDTO> artists;

    public AlbumDTO(){}

    public AlbumDTO(Long id, String name, String pictureUrl, List<ArtistDTO> artists){
        this.id = id;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.artists = artists;
    }

    public Album toAlbum(){
        Album album = new Album();
        album.setId(this.id);
        album.setPictureUrl(this.pictureUrl);
        album.setName(this.name);
        return album;
    }

}
