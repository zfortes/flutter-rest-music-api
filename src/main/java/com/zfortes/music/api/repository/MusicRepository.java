package com.zfortes.music.api.repository;

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
    List<Music> findByAlbum(Album album);
}
