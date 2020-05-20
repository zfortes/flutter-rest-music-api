package com.zfortes.music.api.services;

import com.zfortes.music.api.domain.AppUser;
import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.domain.Music;
import com.zfortes.music.api.domain.Playlist;
import com.zfortes.music.api.repository.MusicRepository;
import com.zfortes.music.api.repository.PlaylistRepository;
import com.zfortes.music.api.repository.UserRepository;
import com.zfortes.music.api.services.dtos.AlbumDTO;
import com.zfortes.music.api.services.dtos.PlaylistDTO;
import com.zfortes.music.api.services.mappers.AlbumMapper;
import com.zfortes.music.api.services.mappers.AppUserMapper;
import com.zfortes.music.api.services.mappers.PlaylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaylistService {
    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    MusicRepository musicRepository;

    @Autowired
    UserRepository appUserRepository;

    public ResponseEntity<?> insert(PlaylistDTO playlistDTO) {
        Playlist playlist = null;
        AppUser appUser = AppUserMapper.toAppUser(playlistDTO.getAppUser());
        boolean appUserIsPresent = appUserRepository.existsAppUserByIdAndUsername(appUser.getId(), appUser.getUsername());

        if (appUserIsPresent)
            playlist = playlistRepository.save(PlaylistMapper.toPlaylist(playlistDTO));
        if (playlist != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("ok");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not created");
        }
    }

    public ResponseEntity<PlaylistDTO> findById(Long id) {
        return ResponseEntity.ok().body(PlaylistMapper.toDto(playlistRepository.findById(id).get()));
    }

    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok()
                .body(playlistRepository.findAll().stream().map(PlaylistMapper::toDto).collect(Collectors.toList()));
    }

    public ResponseEntity<?> update(PlaylistDTO playlistDTO) {
        if (playlistDTO.getId() != null)
            return ResponseEntity.ok()
                    .body(PlaylistMapper.toDto(playlistRepository.save(PlaylistMapper.toPlaylist(playlistDTO))));
        else
            return ResponseEntity.badRequest().body("ID is not set null");
    }

    public ResponseEntity<?> addMusicToPlaylist(Long idPlaylist, Long idMusic) {
        Optional<Music> music = musicRepository.findById(idMusic);
        if (!music.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Music not add");
        }

        boolean isPresent = playlistRepository.existsPlaylistByIdAndMusics(idPlaylist, music.get());

        if (isPresent) {
            return ResponseEntity.badRequest().body("Music not add");
        }

        Optional<Playlist> playlist = playlistRepository.findById(idPlaylist);
        if (playlist.isPresent()) {
            Playlist playlist1 = playlist.get();
            playlist1.addMusic(music.get());
            return ResponseEntity.ok().body(PlaylistMapper.toDto(playlistRepository.save(playlist1)));
        }else {
            return ResponseEntity.badRequest().body("Music not add");
        }
    }

    public ResponseEntity<?> removeMusic(Long idPlaylist, Long idMusic) {
        Optional<Music> music = musicRepository.findById(idMusic);
        if (!music.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Music not removed");
        }

        boolean isPresent = playlistRepository.existsPlaylistByIdAndMusics(idPlaylist, music.get());

        if (isPresent) {
            return ResponseEntity.badRequest().body("Music not be removed");
        }

        Optional<Playlist> playlist = playlistRepository.findById(idPlaylist);
        if (playlist.isPresent()) {
            Playlist playlist1 = playlist.get();
            playlist1.removeMusic(music.get());
            return ResponseEntity.ok().body(PlaylistMapper.toDto(playlistRepository.save(playlist1)));
        }else {
            return ResponseEntity.badRequest().body("Music not be removed");
        }
    }


    public ResponseEntity<?> findPlaylistsByAppUser(Long id) {
        Optional<AppUser>  appUser = appUserRepository.findById(id);
        if (appUser.isPresent()) {
            List<PlaylistDTO> list = playlistRepository.findPlaylistsByAppUser(appUser.get())
                    .stream().map(PlaylistMapper::toDto).collect(Collectors.toList());
            return ResponseEntity.ok().body(list);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<?> deleteById(Long id) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        if (playlist.isPresent()) {
            return ResponseEntity.ok().body(PlaylistMapper.toDto(playlistRepository.save(playlist.get())));
        }else {
            return ResponseEntity.badRequest().body("Music not be removed");
        }
    }
}
