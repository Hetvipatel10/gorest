package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
    int idNumber;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RestAssured.basePath = "/users";
        Object response = given()
                .when()
                .get()
                .then().statusCode(200);
    }


        @Test
    public void GetAllRecord(){
        Response response=given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void CreateStore(){

        UserPojo pojo=new UserPojo();
        pojo.setName("sky");
        pojo.setEmail("skypatel@gmail.com");
        pojo.setGender("male");


        Response response= given()
                .header("Content-Type","application/json")
                .body(pojo)
                .post();
        response.then().log().all().statusCode(201);
        response.prettyPrint();


    }
}
