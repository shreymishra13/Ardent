package com.ardent.backend.repository;


import com.ardent.backend.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface BookRespository extends MongoRepository<Book, String> {

    List<Book> findBySellerId(String sellerId);

    Optional<Book> findByBookName(String bookName);
}
