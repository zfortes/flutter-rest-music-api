package com.zfortes.music.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToMany(mappedBy = "artists")
    private List<Album> albums;

    public Artist(){}

    public Artist(Long id, String name, String pictureUrl){
        this.id = id;
        this.name = name;
        this.pictureUrl = pictureUrl;
    }

    public ArtistDTO toDto(){
        return new ArtistDTO(
                this.id,
                this.name,
                this.pictureUrl
        );
    }
}