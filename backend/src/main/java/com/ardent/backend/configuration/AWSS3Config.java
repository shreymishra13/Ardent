package com.ardent.backend.configuration;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AWSS3Config {

    @Autowired
    AppCache appCache;


    @Bean
    public S3Client s3Client() {
        AwsBasicCredentials credentials =
                AwsBasicCredentials.create(appCache.getAppCacheMap().get("aws.s3.accessKey"), appCache.getAppCacheMap().get("aws.s3.secretKey"));

        return S3Client.builder()
                .region(Region.of(appCache.getAppCacheMap().get("aws.s3.region")))
                .credentialsProvider(
                        StaticCredentialsProvider.create(credentials)
                )
                .build();
    }
}
