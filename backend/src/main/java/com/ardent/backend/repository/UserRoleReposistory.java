package com.ardent.backend.repository;

import com.ardent.backend.entity.UserRole;
import com.ardent.backend.entity.UserRoleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

 public interface UserRoleReposistory extends MongoRepository<UserRoleDocument, String> {
}
