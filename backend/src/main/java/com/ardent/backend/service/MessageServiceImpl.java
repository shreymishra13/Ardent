package com.ardent.backend.service;

import com.ardent.backend.dto.MessageRequestDTO;
import com.ardent.backend.entity.Message;
import com.ardent.backend.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Slf4j
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void contact(MessageRequestDTO messageRequestDTO) {
        log.info("Reached here with message DTO : " + messageRequestDTO);

        Message message = new Message();
        message.setContactNo(messageRequestDTO.getContact());
        message.setMessage(messageRequestDTO.getMessage());
        message.setName(messageRequestDTO.getName());
        message.setEmail(messageRequestDTO.getEmail());
        message.setCreatedAt(LocalDate.now());


        log.info("Sending the Data message to DB : " + message);

        messageRepository.save(message);
        log.info("Message Saved successfully");


    }
}
