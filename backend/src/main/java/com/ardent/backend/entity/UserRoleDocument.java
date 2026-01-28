package com.ardent.backend.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
public class UserRoleDocument {
    @Id
    private String id;

    private UserRole code;

    private String displayName;
}
