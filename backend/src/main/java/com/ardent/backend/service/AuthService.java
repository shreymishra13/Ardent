package com.ardent.backend.service;

import com.ardent.backend.dto.SignupRequestDTO;

public interface AuthService {
    void signup(SignupRequestDTO request);

}
