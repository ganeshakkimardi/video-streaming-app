package com.videostreaming.movie_streaming_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

@RestController
public class MovieStreamController {

    public static final String VIDEO_DIRECTORY = "G:\\Stream\\";
    private static final Logger log = LoggerFactory.getLogger(MovieStreamController.class);

    @GetMapping("/stream/{videoPath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath) throws FileNotFoundException {
        File file = new File(VIDEO_DIRECTORY + videoPath);
        System.out.println(Arrays.toString(new File("G:\\Stream\\").list()));
        if(file.exists()) {
            System.out.println("Looking for file at: " + file.getAbsolutePath());
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().contentType(MediaType.valueOf("video/mp4"))
                    .body(inputStreamResource);
        } else {
           return ResponseEntity.notFound().build();
        }
    }
}
