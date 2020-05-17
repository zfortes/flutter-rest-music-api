package com.zfortes.music.api.domain;

import com.zfortes.music.api.services.dtos.AlbumDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String pictureUrl;

    @ManyToMany
    private List<Artist> artists;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Music> musics;

    public AlbumDTO toDto() {
        return new AlbumDTO(
                this.id,
                this.name,
                this.pictureUrl
        );
    }
}