package com.ardent.backend.controller;


import com.ardent.backend.dto.UserRoleDTO;
import com.ardent.backend.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/roles")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService ;


    @GetMapping()
    public List<UserRoleDTO> getUserRoles(){

        log.info("Reached in the USER role DTO to fetch the userRoles from db");

        return userRoleService.getUserRoles();



    }
}
