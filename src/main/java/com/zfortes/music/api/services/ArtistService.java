package com.zfortes.music.api.services;

import com.zfortes.music.api.repository.ArtistRepository;
import com.zfortes.music.api.services.dtos.ArtistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public ResponseEntity<?> insert(ArtistDTO artistDTO){
        return ResponseEntity.ok().body(artistRepository.save(artistDTO.toDto()));
    }
}
