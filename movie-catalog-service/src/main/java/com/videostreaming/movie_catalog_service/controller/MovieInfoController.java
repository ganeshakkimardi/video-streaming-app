package com.videostreaming.movie_catalog_service.controller;

import com.videostreaming.movie_catalog_service.movie.MovieInfo;
import com.videostreaming.movie_catalog_service.movie.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieInfoController {

    @Autowired
    private MovieInfoRepository repository;

    @PostMapping("/movie-info/save")
    public List<MovieInfo> saveAll(@RequestBody List<MovieInfo> movieInfoList) {
        return repository.saveAll(movieInfoList);
    }

    @GetMapping("/movie-info/list")
    public List<MovieInfo> getAll() {
        return repository.findAll();
    }
}
