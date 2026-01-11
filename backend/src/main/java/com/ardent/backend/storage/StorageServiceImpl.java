package com.ardent.backend.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

@Service
public class StorageServiceImpl implements StorageService{


    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Value("${aws.s3.region}")
    private String region;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        // 1. Generate unique file name
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename().replaceAll(" ","");

        // 2. Build S3 upload request
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(file.getContentType())
                .build();

        // 3. Upload file to S3
        s3Client.putObject(
                putObjectRequest,
                RequestBody.fromBytes(file.getBytes())
        );

        // 4. Return public S3 URL
        return "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + fileName;

       // s3://amzn-s3-book-img/2c08e209-f65e-4921-863a-64a518ca9a6a_Screenshot 2026-01-10 144223.png
    }

}
