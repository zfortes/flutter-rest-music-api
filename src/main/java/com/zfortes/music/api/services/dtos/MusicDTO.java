package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:44
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.domain.Music;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

public class MusicDTO {
    private Long id;

    @NotNull
    private String name;

    private Album album;

    private List<Artist> artist;

    private String duration;

    private String pictureUrl;

    private String musicUrl;

    private String genre;

    public Music toMusic(){
        Music music = new Music();
        music.setId(this.id);
        music.setAlbum(this.album);
        music.setArtist(this.artist);
        music.setDuration(this.duration);
        music.setGenre(this.genre);
        music.setMusicUrl(this.musicUrl);
        music.setName(this.name);
        music.setPictureUrl(this.pictureUrl);
        return music;
    }
}
