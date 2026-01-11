package com.ardent.backend.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "books")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Book{

    @Id
    private String id;

    @Indexed
    private String bookName;

    @Indexed
    private String authorName;

    private Genre bookGenre;
    private String description;
    private Double price;
    private Double discount;
    private Integer stock;
    private String sellerId;
    private LocalDate createdAt;

    private String imgUrl;


}
