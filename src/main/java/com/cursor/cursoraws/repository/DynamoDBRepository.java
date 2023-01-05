package com.cursor.cursoraws.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cursor.cursoraws.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DynamoDBRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public void create(Person person) {
        dynamoDBMapper.save(person);
    }

    public Person getPersonById(Long personId) {
        return dynamoDBMapper.load(Person.class, personId);
    }
}