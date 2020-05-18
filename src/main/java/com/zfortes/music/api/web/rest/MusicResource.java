package com.zfortes.music.api.web.rest;

import com.zfortes.music.api.services.MusicService;
import com.zfortes.music.api.services.dtos.MusicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/music")
public class MusicResource {
    @Autowired
    private MusicService musicService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MusicDTO musicDTO){
        return musicService.save(musicDTO);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(musicService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return musicService.findById(id);
    }

    @GetMapping("/find/album/{id}")
    public ResponseEntity<?> findByAlbum(@PathVariable Long id){
        return musicService.findByAlbum(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return musicService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody MusicDTO musicDTO){
        return musicService.save(musicDTO);
    }
}
