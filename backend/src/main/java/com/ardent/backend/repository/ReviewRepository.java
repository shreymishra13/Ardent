package com.ardent.backend.repository;

import com.ardent.backend.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review , String> {

    List<Review> findByBookId(String bookId);

    List<Review> findByUserId(String userId);
}
