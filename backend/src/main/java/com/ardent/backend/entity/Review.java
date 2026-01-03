package com.ardent.backend.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@Document(collection = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {

    @Id
    private String id;

    @Indexed
    private String bookId;

    @Indexed
    private String userId;

    private Short rating;
    private String message;

    private Date createdAt;








}
