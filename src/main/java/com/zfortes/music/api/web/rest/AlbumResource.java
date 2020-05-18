package com.zfortes.music.api.web.rest;

import com.zfortes.music.api.services.AlbumService;
import com.zfortes.music.api.services.dtos.AlbumDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/album")
public class AlbumResource {
    @Autowired
    AlbumService albumService;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody AlbumDTO albumDTO){
        return albumService.save(albumDTO);
    }

    @PostMapping("/update/add/artist")
    public ResponseEntity<?> insertArtist(@RequestBody Map<String, Long> json){
        return albumService.insertArtist(json.get("albumID"), json.get("artistID"));
    }

    //TODO implementation not finished
    @PostMapping("/update/add/music")
    public ResponseEntity<?> insertMusic(@RequestBody Map<String, Long> json){
        return albumService.insertMusic(json.get("albumID"), json.get("musicID"));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(albumService.findAll());
    }

    @GetMapping("/find/artist/{id}")
    public ResponseEntity<?> findAlbumsByArtists(@PathVariable Long id){
        return ResponseEntity.ok().body(albumService.findAlbumsByArtists(id));
    }

//    @GetMapping("/find/music/{id}")
//    public ResponseEntity<?> findAlbumsByMusics(@PathVariable Long id){
//        return ResponseEntity.ok().body(albumService.findAlbumsByMusics(id));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return albumService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return albumService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody AlbumDTO albumDTO){
        return albumService.save(albumDTO);
    }
}
