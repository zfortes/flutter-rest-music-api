package com.zfortes.music.api.web.rest;/*
 * @created 04/05/2020 - 17:15
 * @project api
 * @author José Fortes
 **/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;

import java.io.*;



//TODO implement Spring Content for correct controller
@RestController
@RequestMapping ("/music")
public class FileResource {

    private final Logger logger = LoggerFactory.getLogger(FileResource.class);

    @GetMapping(value = "/stream", produces = "audio/mp3")
    @ResponseBody
    public FileSystemResource videoSource() {
        final String home = System.getProperty("user.home");
        final File directory = new File(home + File.separator + "Documents" + File.separator + "sample.mp3");
        return new FileSystemResource(new File(home + File.separator + "Documents" + File.separator + "sample.mp3"));
    }
}