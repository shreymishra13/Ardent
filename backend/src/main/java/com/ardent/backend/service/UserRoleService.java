package com.ardent.backend.service;

import com.ardent.backend.dto.UserRoleDTO;
import com.ardent.backend.entity.UserRole;
import com.ardent.backend.entity.UserRoleDocument;
import com.ardent.backend.repository.UserRoleReposistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserRoleService {

    @Autowired
    UserRoleReposistory userRoleReposistory;

    public List<UserRoleDTO> getUserRoles() {
        log.info("Reached in userRole service layer to fetch the user role from DB");

        List<UserRoleDocument> userRoles =  userRoleReposistory.findAll();

        List<UserRoleDTO> userRoleDTOList = new ArrayList<>();
        for(UserRoleDocument userRole : userRoles){
            userRoleDTOList.add(new UserRoleDTO(userRole.getCode().toString() , userRole.getDisplayName()));
        }

        log.info("Return UserRoleDTO list : " + userRoleDTOList);

        return userRoleDTOList ;

    }
}
