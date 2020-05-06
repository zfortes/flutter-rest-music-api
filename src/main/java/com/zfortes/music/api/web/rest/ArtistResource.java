package com.zfortes.music.api.web.rest;

import com.zfortes.music.api.services.ArtistService;
import com.zfortes.music.api.services.dtos.ArtistDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistResource {
    private ArtistService artistService;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ArtistDTO artistDTO){
        return artistService.insert(artistDTO);
    }
}
