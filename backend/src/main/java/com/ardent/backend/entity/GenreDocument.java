package com.ardent.backend.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genres")
@Data
public class GenreDocument {

    @Id
    private String id;

    private Genre code;

    private String displayName;
}

