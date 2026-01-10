package com.ardent.backend.controller;


import com.ardent.backend.dto.ApiResponseDTO;
import com.ardent.backend.dto.SignupRequestDTO;
import com.ardent.backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDTO<Void>> signup(@Valid @RequestBody SignupRequestDTO request){


            log.info("Reached here with SignupReqeustDTO :  "+  request);
            authService.signup(request);
            ApiResponseDTO apiResponseDTO = new ApiResponseDTO(
                    true ,
                    "Signup Successfully, Please login. Redirecting!",
                    null

            );

            return ResponseEntity.status(HttpStatus.CREATED).body(apiResponseDTO);




    }

}
