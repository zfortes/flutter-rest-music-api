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

    public ResponseEntity<?> save(MusicDTO musicDTO){
        return ResponseEntity.ok().body(musicRepository.save(musicDTO.toMusic()));
    }

    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(musicRepository.findAll());
    }

    public ResponseEntity<?> findById(Long id) {
        return ResponseEntity.ok().body(musicRepository.findById(id).get().toDto());
    }

    public ResponseEntity<?> deleteById(Long id) {
        musicRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete");
    }
}
