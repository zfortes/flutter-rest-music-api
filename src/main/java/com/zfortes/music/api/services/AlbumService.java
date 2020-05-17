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
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Artist artist = artistRepository.findById(idArtist).get();
        List<Album> albums = albumRepository.findAlbumsByArtists(artist);
        Album album = albumRepository.findById(idAlbum).get();

        if (!albums.contains(album)) {
            artist = artistRepository.findById(idArtist).get();
            List<Artist> list = album.getArtists();
            list.add(artist);
            album.setArtists(list);
            return ResponseEntity.ok().body(albumRepository.save(album).toDto());
        }else{
            return ResponseEntity.badRequest().body("Artist not add");
        }
    }

    public ResponseEntity<?> insertMusic(Long idAlbum, Long idMusic) {
        Music music = musicRepository.findById(idMusic).get();
        List<Music> musics = albumRepository.findAlbumsByMusics(music);
        Album album = albumRepository.findById(idAlbum).get();

        if (!musics.contains(album)) {
            music = musicRepository.findById(idMusic).get();
            List<Music> list = album.getMusics();
            list.add(music);
            album.setMusics(list);
            return ResponseEntity.ok().body(albumRepository.save(album).toDto());
        }else{
            return ResponseEntity.badRequest().body("Music not add");
        }
    }

    public ResponseEntity<List<AlbumDTO>> findAlbumsByArtists(Long artistID) {
        Artist artist = artistRepository.findById(artistID).get();
        List<AlbumDTO> list = albumRepository.findAlbumsByArtists(artist).stream().map(AlbumMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }
}
