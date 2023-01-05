package com.cursor.cursoraws.services;

import com.cursor.cursoraws.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SaveInS3Service {

    private final DynamoDBService dynamoDBService;
    private final BucketS3Service bucketS3Service;

    public void saveDynamoDocInS3(Long personId) throws IOException {
        Person person = dynamoDBService.getPersonById(personId);
        String doc = person.getDoc();
        String personName = person.getName();
        String bucketName = personName + "bucket";

        bucketS3Service.createS3Bucket(bucketName);
        bucketS3Service.saveDocuments(doc, bucketName);
    }
}
