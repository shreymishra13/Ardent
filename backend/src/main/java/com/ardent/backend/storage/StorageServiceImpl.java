package com.ardent.backend.storage;

import com.ardent.backend.configuration.AppCache;
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
    AppCache appCache;

    @Autowired
    private S3Client s3Client;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        // 1. Generate unique file name
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename().replaceAll(" ","");

        // 2. Build S3 upload request
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(appCache.getAppCacheMap().get("aws.s3.bucketName"))
                .key(fileName)
                .contentType(file.getContentType())
                .build();

        // 3. Upload file to S3
        s3Client.putObject(
                putObjectRequest,
                RequestBody.fromBytes(file.getBytes())
        );

        // 4. Return public S3 URL
        return "https://" + appCache.getAppCacheMap().get("aws.s3.bucketName") + ".s3." + appCache.getAppCacheMap().get("aws.s3.region") + ".amazonaws.com/" + fileName;

       // s3://amzn-s3-book-img/2c08e209-f65e-4921-863a-64a518ca9a6a_Screenshot 2026-01-10 144223.png
    }

}
