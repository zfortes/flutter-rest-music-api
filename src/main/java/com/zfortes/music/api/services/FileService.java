package com.zfortes.music.api.services;/*
 * @created 06/05/2020 - 02:39
 * @project api
 * @author fortes
 */

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
//TODO fix validation implementatios
@Service
public class FileService {
    public ResponseEntity<?> musicSource(String musicPath) {
        File file = new File(musicPath);
        return ( file.exists() ) ? ResponseEntity.ok().body(new FileSystemResource(new File(musicPath))) : ResponseEntity.ok().body("File dont exist");
    }
}
