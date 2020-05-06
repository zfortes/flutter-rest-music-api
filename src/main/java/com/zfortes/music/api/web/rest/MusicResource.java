package com.zfortes.music.api.web.rest;

import com.zfortes.music.api.services.MusicService;
import com.zfortes.music.api.services.dtos.MusicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
public class MusicResource {
    @Autowired
    private MusicService musicService;

    @PostMapping
    public ResponseEntity<?> insertMusic(@RequestBody MusicDTO musicDTO){
        return musicService.insertMusic(musicDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(musicService.getAll());
    }
    
    
}
