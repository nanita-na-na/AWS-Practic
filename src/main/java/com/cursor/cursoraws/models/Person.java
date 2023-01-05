package com.cursor.cursoraws.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @DynamoDBHashKey(attributeName = "person_id")
    private Long id;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private int age;

    @DynamoDBAttribute
    private String doc;

    @DynamoDBAttribute
    private String email;
}
