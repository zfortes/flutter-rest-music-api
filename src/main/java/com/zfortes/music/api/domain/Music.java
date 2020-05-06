package com.zfortes.music.api.domain;

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
}