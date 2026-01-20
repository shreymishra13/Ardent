package com.ardent.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class GenreResponseDTO {
    private String code;
    private String displayName;
}

