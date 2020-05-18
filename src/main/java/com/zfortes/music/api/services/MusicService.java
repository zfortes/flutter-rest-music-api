package com.zfortes.music.api.services;

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Music;
import com.zfortes.music.api.repository.AlbumRepository;
import com.zfortes.music.api.repository.MusicRepository;
import com.zfortes.music.api.services.dtos.MusicDTO;
import com.zfortes.music.api.services.mappers.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private AlbumRepository albumRepository;

    //TODO erro album null
    public ResponseEntity<?> save(MusicDTO musicDTO) {
        Music music = musicRepository.save(musicDTO.toMusic());
        if (music != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        } else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("No created");
        }
    }

    public ResponseEntity<?> findAll(){
        List<MusicDTO> musics = musicRepository.findAll()
                .stream().map(MusicMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok().body(musics);
    }

    public ResponseEntity<?> findById(Long id) {
        return ResponseEntity.ok().body(MusicMapper.toDto(musicRepository.findById(id).get()));
    }

    public ResponseEntity<?> deleteById(Long id) {
        musicRepository.deleteById(id);
        return ResponseEntity.ok().body("Deleted");
    }

    public ResponseEntity<?> findByAlbum(Long id) {
        Optional<Album> album = albumRepository.findById(id);
        if (!album.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<MusicDTO> musics = musicRepository.findByAlbum(album.get())
                .stream().map(MusicMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok().body(musics);
    }

//    public ResponseEntity<?> insertAlbum(Long idAlbum, Long idMusic) {
//        Optional<Music> music = musicRepository.findById(idMusic);
//        if (!music.isPresent()){
//            return ResponseEntity.badRequest().body("Music not add");
//        }
//
//        boolean isPresent = albumRepository.existsAlbumsByIdAndMusics(idAlbum, music.get());
//
//        if (isPresent) {
//            return ResponseEntity.badRequest().body("Music not add");
//        }
//
//        Optional<Album> album = albumRepository.findById(idAlbum);
//        if (album.isPresent()) {
//            Album album1 = album.get();
//            List<Music> list = album1.getMusics();
//            list.add(music.get());
//            album1.setMusics(list);
//            return ResponseEntity.ok().body(AlbumMapper.toDto(albumRepository.save(album1)));
//        }else {
//            return ResponseEntity.badRequest().body("Music not add");
//        }
//    }
}
