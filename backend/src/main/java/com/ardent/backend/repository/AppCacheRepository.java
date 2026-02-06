package com.ardent.backend.repository;

import com.ardent.backend.entity.AppCacheEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppCacheRepository extends MongoRepository<AppCacheEntity , String> {
}
