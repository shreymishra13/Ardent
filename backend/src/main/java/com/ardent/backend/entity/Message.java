package com.ardent.backend.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;

@Document(collection = "messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Message {

    @Id
    private String id;

    @Indexed
    private String email;

    private String name ;
    private String contactNo;
    private String message;

    private LocalDate createdAt;



}
