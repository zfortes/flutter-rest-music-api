package com.zfortes.music.api.services;

import com.zfortes.music.api.domain.Album;
import com.zfortes.music.api.domain.Artist;
import com.zfortes.music.api.domain.Music;
import com.zfortes.music.api.repository.AlbumRepository;
import com.zfortes.music.api.repository.ArtistRepository;
import com.zfortes.music.api.repository.MusicRepository;
import com.zfortes.music.api.services.dtos.AlbumDTO;
import com.zfortes.music.api.services.mappers.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    MusicRepository musicRepository;

    public ResponseEntity<AlbumDTO> save(AlbumDTO albumDTO) {
        return ResponseEntity.ok().body(albumRepository.save(albumDTO.toAlbum()).toDto());
    }

    public ResponseEntity<AlbumDTO> findById(Long id) {
        return ResponseEntity.ok().body(albumRepository.findById(id).get().toDto());
    }

    public ResponseEntity<List<AlbumDTO>> findAll() {
        return ResponseEntity.ok()
                .body(albumRepository.findAll().stream().map(AlbumMapper::toDto).collect(Collectors.toList()));
    }

    public ResponseEntity<?> update(AlbumDTO albumDTO) {
        if (albumDTO.getId() != null)
            return ResponseEntity.ok().body(albumRepository.save(albumDTO.toAlbum()).toDto());
        else
            return ResponseEntity.badRequest().body("ID is not set null");
    }

    public ResponseEntity<?> deleteById(Long id) {
        albumRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete");
    }

    public ResponseEntity<?> insertArtist(Long idAlbum, Long idArtist) {
        Optional<Artist> artist = artistRepository.findById(idArtist);
        if (!artist.isPresent()){
            return ResponseEntity.badRequest().body("Artist not add");
        }

        boolean isPresent = albumRepository.existsAlbumsByIdAndArtists(idAlbum, artist.get());

        if (isPresent) {
            return ResponseEntity.badRequest().body("Artist not add");
        }

        Optional<Album> album = albumRepository.findById(idAlbum);
        if (album.isPresent()) {
            Album album1 = album.get();
            List<Artist> list = album1.getArtists();
            list.add(artist.get());
            album1.setArtists(list);
            return ResponseEntity.ok().body(albumRepository.save(album1).toDto());
        }else {
            return ResponseEntity.badRequest().body("Artist not add");
        }
    }

    public ResponseEntity<?> insertMusic(Long idAlbum, Long idMusic) {
        Optional<Music> music = musicRepository.findById(idMusic);
        if (!music.isPresent()){
            return ResponseEntity.badRequest().body("Music not add");
        }

        boolean isPresent = albumRepository.existsAlbumsByIdAndMusics(idAlbum, music.get());

        if (isPresent) {
            return ResponseEntity.badRequest().body("Music not add");
        }

        Optional<Album> album = albumRepository.findById(idAlbum);
        if (album.isPresent()) {
            Album album1 = album.get();
            List<Music> list = album1.getMusics();
            list.add(music.get());
            album1.setMusics(list);
            return ResponseEntity.ok().body(albumRepository.save(album1).toDto());
        }else {
            return ResponseEntity.badRequest().body("Music not add");
        }
    }

    public ResponseEntity<List<AlbumDTO>> findAlbumsByArtists(Long artistID) {
        Optional<Artist> artist = artistRepository.findById(artistID);
        if (artist.isPresent()) {
            List<AlbumDTO> list = albumRepository.findAlbumsByArtists(artist.get())
                    .stream().map(AlbumMapper::toDto).collect(Collectors.toList());
            return ResponseEntity.ok().body(list);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    public ResponseEntity<AlbumDTO> findAlbumsByMusics(Long id) {
//        Optional<Music> music = musicRepository.findById(id);
//        if (!music.isPresent()) {
//            return ResponseEntity.ok().build();
//        }
//        Optional<Album> album = musicRepository.findByAlbum();
//        if (!album.isEmpty()){
//            return ResponseEntity.ok().body();
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
}
