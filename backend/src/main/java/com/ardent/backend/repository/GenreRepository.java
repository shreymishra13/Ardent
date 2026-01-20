package com.ardent.backend.repository;

import com.ardent.backend.entity.GenreDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<GenreDocument , String> {
}
