package com.ardent.backend.controller;


import com.ardent.backend.dto.ApiResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
@Slf4j
public class HealthCheckController {

    @GetMapping("/getHealthStatus")
    public ResponseEntity<ApiResponseDTO<Void>> getHealthStatus(){

        log.info("Get Health Status Ok.");

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO(
                true ,
                "Get Health Status Ok",
                null
        ));
    }
}
