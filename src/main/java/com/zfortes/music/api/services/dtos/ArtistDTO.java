package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:43
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Artist;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

public class ArtistDTO {
    private Long id;

    @NotNull
    private String name;

    private String pictureUrl;

    public Artist toDto(){
        Artist artist = new Artist();
        artist.setId(this.id);
        artist.setName(this.name);
        artist.setPictureUrl(this.pictureUrl);
        return artist;
    }
}
