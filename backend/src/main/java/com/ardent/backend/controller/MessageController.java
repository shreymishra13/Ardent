package com.ardent.backend.controller;


import com.ardent.backend.dto.ApiResponseDTO;
import com.ardent.backend.dto.MessageDTO;
import com.ardent.backend.service.MessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    @PostMapping("/contact")
    public ResponseEntity<ApiResponseDTO> contact(@RequestBody MessageDTO message){

        log.info("Reached here with MessageDTO : " + message);


        messageService.contact(message);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponseDTO(
                true ,
                "Message Recieved successfully"
        ));

    }
}
