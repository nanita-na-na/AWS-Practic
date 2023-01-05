package com.cursor.cursoraws.services;

import com.cursor.cursoraws.models.Person;
import com.cursor.cursoraws.repository.DynamoDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DynamoDBService {

   private final DynamoDBRepository dynamoDBRepository;

    public void createPersonDynamoDB(Person person) {
        dynamoDBRepository.create(person);
    }

    public Person getPersonById(Long personId) {
        return dynamoDBRepository.getPersonById(personId);
    }

    public String getEmailByPersonId(Long personId){
        return getPersonById(personId).getEmail();
    }
}
