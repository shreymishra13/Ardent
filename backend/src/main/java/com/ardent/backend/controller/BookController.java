package com.ardent.backend.controller;


import com.ardent.backend.dto.ApiResponseDTO;
import com.ardent.backend.dto.BookRequestDTO;
import com.ardent.backend.dto.BookResponseDTO;
import com.ardent.backend.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    @Autowired
    BookService bookService ;

    @PostMapping(
            value = "/book",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ApiResponseDTO<Void>> addBook(
            @ModelAttribute BookRequestDTO bookRequestDTO,
            @RequestPart("image") MultipartFile img
    ) throws IOException {

        bookService.addBook(bookRequestDTO, img);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new ApiResponseDTO<>(
                        true,
                        "Book Added Successfully!",
                        null
                ));
    }








    @GetMapping("allBooks")
    public ResponseEntity<ApiResponseDTO<List<BookResponseDTO>>> getAllBooks(){

      List<BookResponseDTO> allBooks = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO<>(
                true,
                "Book return successfully",
                allBooks

        ));
    }

}
