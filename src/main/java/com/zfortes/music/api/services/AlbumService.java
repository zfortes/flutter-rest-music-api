package com.zfortes.music.api.services;

import com.zfortes.music.api.repository.AlbumRepository;
import com.zfortes.music.api.services.dtos.AlbumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public ResponseEntity<?> insert(AlbumDTO albumDTO){
        return ResponseEntity.ok().body(albumRepository.save(albumDTO.toAlbum()));
    }
}
