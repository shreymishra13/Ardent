package com.ardent.backend.service;

import com.ardent.backend.dto.SignupRequestDTO;
import com.ardent.backend.entity.User;
import com.ardent.backend.entity.UserRole;
import com.ardent.backend.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService{


    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signup(SignupRequestDTO request){

        if (userRepository.existsByEmail(request.getEmail())){
            log.info("Some exception has occurred, SignupRequestDTO  " + request + "Email already registered. Try logging In");
            log.error("Some exception has occurred, SignupRequestDTO  " + request + "Email already registered. Try logging In");

            throw new IllegalArgumentException("Email already registered. Try logging In");


        }
        if(request.getRole() == UserRole.ADMIN){
            log.info("Some exception has occurred, SignupRequestDTO  " + request + "Admin can't be created !!");
            log.error("Some exception has occurred, SignupRequestDTO  " + request + "Admin can't be created !!");
            throw new IllegalArgumentException("Admin can't be created !!");

        }

        User user = new User();
        user.setName(request.getName());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setPincode(request.getPincode());
        user.setContactNo(request.getContactNo());
        user.setUserRole(request.getRole());

        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(user.getCreatedAt());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        log.info("Successfully save the user in DB :" + user + "Returning from here");





    }
}
