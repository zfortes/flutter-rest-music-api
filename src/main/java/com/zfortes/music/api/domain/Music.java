package com.zfortes.music.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    private Album album;

    private String duration;

    private String pictureUrl;

    private String musicUrl;

    private String genre;

//    //TODO refatorar o contructor de Music
//    public MusicDTO toDto() {
//        MusicDTO musicDTO = new MusicDTO();
//        musicDTO.setAlbum(this.album);
//        musicDTO.setArtists(null);
//        musicDTO.setDuration(this.duration);
//        musicDTO.setGenre(this.genre);
//        musicDTO.setId(this.id);
//        musicDTO.setMusicUrl(this.musicUrl);
//        musicDTO.setName(this.name);
//        musicDTO.setPictureUrl(this.pictureUrl);
//        return musicDTO;
//    }
}