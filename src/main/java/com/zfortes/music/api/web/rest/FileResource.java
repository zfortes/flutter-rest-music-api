package com.zfortes.music.api.web.rest;/*
 * @created 04/05/2020 - 17:15
 * @project api
 * @author José Fortes
 **/

import com.zfortes.music.api.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



//TODO implement Spring Content for correct controller
@RestController
@RequestMapping ("/stream")
public class FileResource {

    private final Logger logger = LoggerFactory.getLogger(FileResource.class);

    @Autowired
    FileService fileService;

    @GetMapping(value = "/music", produces = "audio/mp3")
    //@ResponseBody
    public ResponseEntity<?> musicSource(@RequestParam("locale") String musicPath) {
        return fileService.musicSource(musicPath);
    }
}