package com.ardent.backend.service;

import com.ardent.backend.dto.BookRequestDTO;
import com.ardent.backend.dto.BookResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {
    public void addBook(BookRequestDTO bookRequestDTO , MultipartFile img) throws IOException;

    public List<BookResponseDTO> getAllBooks();

}
