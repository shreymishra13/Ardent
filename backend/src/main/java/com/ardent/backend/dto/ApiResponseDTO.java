package com.ardent.backend.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponseDTO {

    private boolean success;
    private String message;


}

