package com.zfortes.music.api.domain;

import com.zfortes.music.api.services.dtos.ArtistDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String pictureUrl;

    @ManyToMany(cascade=CascadeType.ALL)
    private List<Album> albums;

    public Artist(){}

    public Artist(Long id, String name, String pictureUrl, List<Album> albums){
        this.id = id;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.albums = albums;
    }

    public ArtistDTO toDto(){
        return new ArtistDTO(
                this.id,
                this.name,
                this.pictureUrl,
                this.albums
        );
    }
}