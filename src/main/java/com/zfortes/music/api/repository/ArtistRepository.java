package com.zfortes.music.api.repository;

import com.zfortes.music.api.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findById(Long id);
}
