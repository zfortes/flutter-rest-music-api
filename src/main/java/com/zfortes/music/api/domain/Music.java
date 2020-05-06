package com.zfortes.music.api.domain;

import com.zfortes.music.api.services.dtos.MusicDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(cascade=CascadeType.ALL)
    private Album album;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Artist> artist;

    private String duration;

    private String pictureUrl;

    private String musicUrl;

    private String genre;

    public MusicDTO toDto() {
        MusicDTO musicDTO = new MusicDTO();
        musicDTO.setAlbum(this.album);
        musicDTO.setArtist(this.artist);
        musicDTO.setDuration(this.duration);
        musicDTO.setGenre(this.genre);
        musicDTO.setId(this.id);
        musicDTO.setMusicUrl(this.musicUrl);
        musicDTO.setName(this.name);
        musicDTO.setPictureUrl(this.pictureUrl);
        return musicDTO;
    }
}