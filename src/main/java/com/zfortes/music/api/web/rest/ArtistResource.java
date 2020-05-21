package com.zfortes.music.api.web.rest;

import com.zfortes.music.api.services.ArtistService;
import com.zfortes.music.api.services.dtos.ArtistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist")
public class ArtistResource {
    @Autowired
    private ArtistService artistService;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ArtistDTO artistDTO){
        return artistService.save(artistDTO);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return  artistService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return artistService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return artistService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody ArtistDTO artistDTO){
        return artistService.save(artistDTO);
    }
}
