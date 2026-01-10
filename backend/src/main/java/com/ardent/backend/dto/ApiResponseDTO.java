package com.ardent.backend.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponseDTO<T> {

    private boolean success;
    private String message;
    private T data;


}

