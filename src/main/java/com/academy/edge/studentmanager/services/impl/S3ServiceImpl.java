package com.academy.edge.studentmanager.services.impl;

import com.academy.edge.studentmanager.services.S3Service;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
@Service
@Log4j2
public class S3ServiceImpl implements S3Service {
    private AmazonS3 s3client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public S3ServiceImpl(AmazonS3 s3client, @Value("${aws.s3.bucket}") String bucketName) {
        this.s3client = s3client;
        this.s3client.createBucket(bucketName);
    }
    public void uploadFile(String keyName, MultipartFile file) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        var putObjectResult = s3client.putObject(bucketName, keyName, file.getInputStream(), metadata);
        log.info(putObjectResult.getMetadata());

    }
    public S3Object getFile(String keyName){
        return s3client.getObject(bucketName, keyName);
    }

    public void deleteFile(String photoUrl) {
        s3client.deleteObject(bucketName, photoUrl);
    }
}
