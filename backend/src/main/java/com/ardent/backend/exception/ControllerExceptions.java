package com.ardent.backend.exception;



import com.ardent.backend.dto.ApiResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDTO> handleValidationException(MethodArgumentNotValidException ex){
        // Take the first validation error message (simple for learning)
        log.info("Got Some exception , " + ex.getMessage());
        log.error("Got Some exception , " + ex.getMessage());
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseDTO(false, errorMessage));

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO> handleValidationException(Exception ex){
        // Take the first validation error message (simple for learning)
        log.info("Got Some exception , " + ex.getMessage());
        log.error("Got Some exception , " + ex.getMessage());
        String errorMessage = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseDTO(false, errorMessage));

    }
}
