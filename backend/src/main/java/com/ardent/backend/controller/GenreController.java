package com.ardent.backend.controller;


import com.ardent.backend.dto.GenreResponseDTO;
import com.ardent.backend.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
@Slf4j
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/")
    public List<GenreResponseDTO> getAllGenres(){

        List<GenreResponseDTO> genreList =  genreService.getAll();
        log.info("Genre list obtained : "+ genreList);

        return genreList;

    }
}
