package com.zfortes.music.api.web.rest;

import com.zfortes.music.api.services.MusicService;
import com.zfortes.music.api.services.PlaylistService;
import com.zfortes.music.api.services.dtos.PlaylistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/playlist")
public class PlaylistResource {
    @Autowired
    PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody PlaylistDTO playlistDTO){
        return playlistService.insert(playlistDTO);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PlaylistDTO playlistDTO){
        return playlistService.update(playlistDTO);
    }

    @PutMapping("/update/add/music")
    public ResponseEntity<?> addMusicToPlaylist(@RequestBody Map<String, Long> json){
        return playlistService.addMusicToPlaylist(json.get("playlistID"), json.get("musicID"));
    }

    @PutMapping("/update/remove/music")
    public ResponseEntity<?> removeMusic(@RequestBody Map<String, Long> json){
        return playlistService.removeMusic(json.get("playlistID"), json.get("musicID"));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(playlistService.findAll());
    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity<?> findPlaylistsByUser(@PathVariable Long id){
        return ResponseEntity.ok().body(playlistService.findPlaylistsByAppUser(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return playlistService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return playlistService.deleteById(id);
    }


}
