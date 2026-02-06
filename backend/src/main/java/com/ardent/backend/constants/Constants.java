package com.ardent.backend.constants;

import lombok.Getter;
import org.springframework.stereotype.Component;


@Component
@Getter
public class Constants {

    private final String AWS_ACCESS_KEY = "aws.s3.accessKey";

    private final String AWS_BUCKET_NAME = "aws.s3.bucketName";

    private final String AWS_REGION = "aws.s3.region";

    private final String AWS_SECRET_KEY = "aws.s3.secretKey";

    private final String DB_NAME = "db_name";

    private final String MONGO_DB_URI = "mongodb_uri";

    private final String DB_PASSWORD = "db_password";


}
