package com.zfortes.music.api.repository;

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findAlbumsByArtists(Artist artistID);
    List<Music> findAlbumsByMusics(Music music);
    //boolean existsAlbumsByArtistsAndAndArtists();
    //boolean existsAlbumsByArtists(Album albums, Artist artists);
}
