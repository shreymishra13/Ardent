package com.ardent.backend.service;

import com.ardent.backend.dto.BookRequestDTO;
import com.ardent.backend.dto.BookResponseDTO;
import com.ardent.backend.entity.Book;
import com.ardent.backend.repository.BookRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService{


    @Autowired
    BookRespository bookRespository;

    @Override
    public void addBook(BookRequestDTO bookRequestDTO , MultipartFile img) throws IOException{

        if(img.isEmpty()){
            throw new RuntimeException("Image is required");

        }
        log.info("Recieved BookRequestDTO " + bookRequestDTO);

        String imgBase64 = Base64.getEncoder().encodeToString(img.getBytes());
        Book book = new Book();
        book.setBookName(bookRequestDTO.getBookName());
        book.setBookGenre(bookRequestDTO.getGenre());
        book.setStock(bookRequestDTO.getStock());
        book.setAuthorName(bookRequestDTO.getAuthorName());
        book.setDiscount(bookRequestDTO.getDiscount());
        book.setCreatedAt(LocalDate.now());
        book.setDescription(bookRequestDTO.getDescription());
        book.setImageBase64(imgBase64);

        log.info("Sending the book data to DB , " + book);
        bookRespository.save(book);
        log.info("Successfully saved in the DB ");


    }


    @Override
    public List<BookResponseDTO> getAllBooks(){
        List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();

        List<Book> books = bookRespository.findAll();
        log.info("All books Recieved from DB : "+ books);

        log.info("Convert book entity to book dto");

        for(Book book : books){
            ObjectMapper objectMapper = new ObjectMapper();
            BookResponseDTO bookResponseDTO = objectMapper.convertValue(book , BookResponseDTO.class);
            log.info("Book Response DTO :  "+ bookResponseDTO);

            bookResponseDTOList.add(bookResponseDTO);
        }


        log.info("Book Response DTO list :" + bookResponseDTOList);
        return bookResponseDTOList;
    }
}
