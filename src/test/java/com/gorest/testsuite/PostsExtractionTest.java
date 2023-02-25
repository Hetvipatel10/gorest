package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RestAssured.basePath = "/posts";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }
    //1. Extract the title
@Test
    public void verifytitle(){
        List<Integer> title = response.extract().path("x.title");
        System.out.println(title);
    }
    //2. Extract the total number of record
    @Test
    public void verifytotalnumbers(){
        List<Integer> record = response.extract().path("url");
       int size= record.size();
        System.out.println(size);
    }
    //3. Extract the body of 15th record
    @Test
    public void extract15threcord() {
        List<String> record = response.extract().path("find{it.id=='20681'}.body");
        System.out.println(record);
    }


    //4. Extract the user_id of all the records
    @Test
    public void verifysatus() {
        List<Integer> record1 = response.extract().path("user_id");
        System.out.println(record1);
    }


    //5. Extract the title of all the records
    @Test
    public void verifytitleofrecords() {
        List<String> record2 = response.extract().path("title");
        System.out.println(record2);
    }


    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void verifytitleofid() {
        List<String> records = response.extract().path("findAll{it.user_id == 574030}.title");
        System.out.println(records);
    }


    //7. Extract the body of all records whose id = 2671
    @Test
    public void verifybody() {
        List<HashMap<String, ?>> records1 = response.extract().path("findAll{it.id == 20690}.body");
        System.out.println(records1);
    }


}

