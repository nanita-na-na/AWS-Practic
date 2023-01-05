package com.cursor.cursoraws.services;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@RequiredArgsConstructor
public class BucketS3Service {

    @Value("${filePath}")
    private String filePath;

    private final AmazonS3 s3;

    public void createS3Bucket(String bucketName) {

        if (!s3.doesBucketExist(bucketName)) {
            s3.createBucket(bucketName);
        } else {
            System.out.println("Bucket with this name already exist!");
        }
    }

    public void saveDocuments(String doc, String bucketName) throws IOException {

        File file = new File("file.pdf");
        Path path = Paths.get(filePath);
        Files.writeString(path, doc, StandardCharsets.UTF_8);

        s3.putObject(bucketName, filePath, file);
    }
}