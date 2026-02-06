package com.ardent.backend.configuration;


import com.ardent.backend.constants.Constants;
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

    @Autowired
    Constants constants;


    @Bean
    public S3Client s3Client() {
        AwsBasicCredentials credentials =
                AwsBasicCredentials.create(appCache.getAppCacheMap().get(constants.getAWS_ACCESS_KEY()), appCache.getAppCacheMap().get(constants.getAWS_SECRET_KEY()));

        return S3Client.builder()
                .region(Region.of(appCache.getAppCacheMap().get(constants.getAWS_REGION())))
                .credentialsProvider(
                        StaticCredentialsProvider.create(credentials)
                )
                .build();
    }
}
