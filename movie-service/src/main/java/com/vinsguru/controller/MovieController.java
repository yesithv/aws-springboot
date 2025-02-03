package com.vinsguru.controller;

import com.vinsguru.domain.Genre;
import com.vinsguru.dto.MovieDto;
import com.vinsguru.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<MovieDto> getAll() {
        return this.movieService.getAll();
    }

    @GetMapping("{pGenre}")
    public List<MovieDto> getAllByGenre(@PathVariable Genre pGenre) {
        return this.movieService.getAll(pGenre);
    }

}
