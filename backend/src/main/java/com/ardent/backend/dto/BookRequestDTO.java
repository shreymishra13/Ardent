package com.ardent.backend.dto;


import com.ardent.backend.entity.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class BookRequestDTO {

    @NotBlank
    private String bookName ;
    @NotBlank
    private String authorName;
    @NotBlank
    private Genre genre;
    @NotBlank
    @Positive
    private double price;

    @NotBlank
    private int stock;

    @NotBlank
    private double discount;

    @NotBlank
    private String description;


}
