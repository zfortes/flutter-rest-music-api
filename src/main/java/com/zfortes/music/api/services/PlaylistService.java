package com.zfortes.music.api.services;

import com.zfortes.music.api.repository.PlaylistRepository;
import com.zfortes.music.api.repository.UserRepository;
import com.zfortes.music.api.services.dtos.AppUserDTO;
import com.zfortes.music.api.services.dtos.PlaylistDTO;
import com.zfortes.music.api.services.mappers.AppUserMapper;
import com.zfortes.music.api.services.mappers.PlaylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {
    @Autowired
    PlaylistRepository playlistRepository;

    public ResponseEntity<PlaylistDTO> save(PlaylistDTO playlistDTO) {
        return ResponseEntity.ok().body(PlaylistMapper.toDto(playlistRepository.save(PlaylistMapper.toPlaylist(playlistDTO))));
    }

    public ResponseEntity<PlaylistDTO> findById(Long id) {
        return ResponseEntity.ok().body(PlaylistMapper.toDto(playlistRepository.findById(id).get()));
    }

    public ResponseEntity<List<PlaylistDTO>> findAll() {
        return ResponseEntity.ok()
                .body(playlistRepository.findAll().stream().map(PlaylistMapper::toDto).collect(Collectors.toList()));
    }

    public ResponseEntity<?> update(PlaylistDTO playlistDTO) {
        if (playlistDTO.getId() != null)
            return ResponseEntity.ok().body(PlaylistMapper.toDto(playlistRepository.save(PlaylistMapper.toPlaylist(playlistDTO))));
        else
            return ResponseEntity.badRequest().body("ID is not set null");
    }
}
