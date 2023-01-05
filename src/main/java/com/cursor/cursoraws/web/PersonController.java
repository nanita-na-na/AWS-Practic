package com.cursor.cursoraws.web;

import com.cursor.cursoraws.models.Person;
import com.cursor.cursoraws.services.DynamoDBService;
import com.cursor.cursoraws.services.SNSService;
import com.cursor.cursoraws.services.SaveInS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class PersonController {
    private final DynamoDBService dynamoDBService;
    private final SNSService snsService;
    private final SaveInS3Service saveService;

    @PostMapping(value = "/person")
    public void createPerson(@RequestBody Person person) {
        dynamoDBService.createPersonDynamoDB(person);
    }

    @GetMapping(value = "/personDoc/{personId}")
    public void saveDoc(@PathVariable Long personId) throws IOException {
        saveService.saveDynamoDocInS3(personId);
    }

    @GetMapping(value = "/subscription/{personId}")
    public void subscription(@PathVariable Long personId) {
        snsService.subscribeToSNSTopic(dynamoDBService.getEmailByPersonId(personId));
    }

    @PostMapping(value = "/message")
    public void sendMessage(@RequestBody String message) {
        snsService.publishToTopic(message);
    }
}