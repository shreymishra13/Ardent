package com.ardent.backend.repository;

import com.ardent.backend.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;



public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findByEmail(String email);
}
