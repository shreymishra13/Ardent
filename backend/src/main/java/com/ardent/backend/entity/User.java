package com.ardent.backend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@Document(collection = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    private String name ;

    @Indexed(unique = true)
    private String email;

    private String password;
    private String address ;
    private String pincode;
    private String contactNo;
    private UserRole userRole;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
