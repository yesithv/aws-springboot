package com.vinsguru.service;

import com.vinsguru.domain.Genre;
import com.vinsguru.dto.MovieDto;
import com.vinsguru.mapper.EntityDtoMapper;
import com.vinsguru.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository ;

    public List<MovieDto> getAll() {
        return this.movieRepository.findAll()
                .stream()
                .map(EntityDtoMapper::toDto)
                .toList();
    }

    public List<MovieDto> getAll(Genre genre) {
        return this.movieRepository.findByGenre(genre)
                .stream()
                .map(EntityDtoMapper::toDto)
                .toList();
    }

}
