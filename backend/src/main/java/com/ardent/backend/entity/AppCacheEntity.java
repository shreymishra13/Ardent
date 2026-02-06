package com.ardent.backend.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appCache")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class AppCacheEntity {
    private String key;
    private String value;
}
