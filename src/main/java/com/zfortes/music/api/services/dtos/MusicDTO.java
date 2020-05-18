package com.zfortes.music.api.services.dtos;/*
 * @created 04/05/2020 - 20:44
 * @project api
 * @author fortes
 */

import com.zfortes.music.api.domain.Music;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
//TODO terminar relacao de music com album
public class MusicDTO {
    private Long id;

    @NotNull
    private String name;

    private AlbumDTO album;

    private String duration;

    private String pictureUrl;

    private String musicUrl;

    private String genre;

    public MusicDTO() {
    }

    public MusicDTO(Long id, String name, AlbumDTO album,
                    String duration, String pictureUrl, String musicUrl, String genre) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.duration = duration;
        this.pictureUrl = pictureUrl;
        this.musicUrl = musicUrl;
        this.genre = genre;
    }

    public Music toMusic() {
        Music music = new Music();
        music.setId(this.id);
        music.setAlbum(null);
        music.setDuration(this.duration);
        music.setGenre(this.genre);
        music.setMusicUrl(this.musicUrl);
        music.setName(this.name);
        music.setPictureUrl(this.pictureUrl);
        return music;
    }
}
