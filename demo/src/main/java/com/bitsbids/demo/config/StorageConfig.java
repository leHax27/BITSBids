package com.bitsbids.demo.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
@Configuration
public class StorageConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey1;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey1;

//    @Value("${application.bucket.name}")
    private final String bucketName="bitsbids";

    @Bean
    public AmazonS3 s3client() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey1, secretKey1);
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion("ap-south-1")
                .build();
    }
}

