package com.ardent.backend.controller;


import com.ardent.backend.configuration.AppCache;
import com.ardent.backend.dto.ApiResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/BootStrapServlet")
public class BootStrapServletController {

    @Autowired
    private AppCache appCache;


    @GetMapping()
    public ResponseEntity<ApiResponseDTO> clearCache(){
        log.info("Bootstrap Servlet called to reset the cache");
        appCache.init();
        log.info("Bootstrap Servlet successfully cleared the cache");

        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO(
                true,
                "Successfully Reset cached",
                null
        ));

    }


}
