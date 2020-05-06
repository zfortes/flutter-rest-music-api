package com.zfortes.music.api.services;

import com.zfortes.music.api.repository.MusicRepository;
import com.zfortes.music.api.services.dtos.MusicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

    public ResponseEntity<?> insertMusic(MusicDTO musicDTO){
        return ResponseEntity.ok().body(musicRepository.save(musicDTO.toMusic()));
    }

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(musicRepository.findAll());
    }

    public ResponseEntity<?> getMusicById(Long id) {
        return ResponseEntity.ok().body(musicRepository.findById(id).get().toDto());
    }
}
