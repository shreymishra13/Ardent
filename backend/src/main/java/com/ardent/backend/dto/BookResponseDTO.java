package com.ardent.backend.dto;

import com.ardent.backend.entity.Genre;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class BookResponseDTO{

    private String bookName;

    private String authorName;

    private Genre bookGenre;
    private String description;
    private Double price;
    private Double discount;
    private Integer stock;
    private String imageBase64;


}