package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:42
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.domain.Music;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

public class AlbumDTO {
    private Long id;

    @NotNull
    private String name;

    private String pictureUrl;

    private List<Artist> artist;

    private List<Music> musics;

    public Album toAlbum(){
        Album album = new Album();
        album.setArtist(this.artist);
        album.setId(this.id);
        album.setMusics(this.musics);
        return album;
    }
}
