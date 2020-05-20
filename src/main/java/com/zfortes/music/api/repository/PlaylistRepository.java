package com.zfortes.music.api.repository;

import com.zfortes.music.api.domain.AppUser;
import com.zfortes.music.api.domain.Music;
import com.zfortes.music.api.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    boolean existsPlaylistByIdAndMusics(Long id, Music music);

    List<Playlist> findPlaylistsByAppUser(AppUser appUser);
}
