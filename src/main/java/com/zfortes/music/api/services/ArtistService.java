package com.zfortes.music.api.services;

import com.zfortes.music.api.repository.ArtistRepository;
import com.zfortes.music.api.services.dtos.ArtistDTO;
import com.zfortes.music.api.services.mappers.ArtistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public ResponseEntity<ArtistDTO> save(ArtistDTO artistDTO) {
        return ResponseEntity.ok().body(artistRepository.save(artistDTO.toArtist()).toDto());
    }

    public ResponseEntity<ArtistDTO> findById(Long id) {
        return ResponseEntity.ok().body(artistRepository.findById(id).get().toDto());
    }

    public ResponseEntity<List<ArtistDTO>> findAll() {
        return ResponseEntity.ok()
                .body(artistRepository.findAll().stream().map(ArtistMapper::toDto).collect(Collectors.toList()));
    }

    public ResponseEntity<?> update(ArtistDTO artistDTO) {
        if (artistDTO.getId() != null)
            return ResponseEntity.ok().body(artistRepository.save(artistDTO.toArtist()).toDto());
        else
            return ResponseEntity.badRequest().body("ID is not set null");
    }

    public ResponseEntity<?> deleteById(Long id) {
        artistRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete");
    }
}
