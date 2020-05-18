package com.zfortes.music.api.repository;

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findAlbumsByArtists(Artist artistID);
    List<Album> findAlbumByMusics(Music music);
    boolean existsAlbumsByIdAndArtists(Long id, Artist artist);
    boolean existsAlbumsByIdAndMusics(Long id, Music music);
}
