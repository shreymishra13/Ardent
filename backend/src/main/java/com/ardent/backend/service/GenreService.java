package com.ardent.backend.service;

import com.ardent.backend.dto.GenreResponseDTO;
import com.ardent.backend.entity.GenreDocument;
import com.ardent.backend.repository.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<GenreResponseDTO> getAll() {

        List<GenreDocument> genreList = genreRepository.findAll();
        List<GenreResponseDTO> genreResponseDTOList = new ArrayList<>();

        for(GenreDocument g : genreList){
            genreResponseDTOList.add(new GenreResponseDTO(g.getCode().name() , g.getDisplayName()));
        }
        log.info("Genre Response DTO list : " + genreResponseDTOList);
        return genreResponseDTOList;



    }
}
