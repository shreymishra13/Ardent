package com.ardent.backend.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    public String uploadFile(MultipartFile File)  throws IOException;
}
