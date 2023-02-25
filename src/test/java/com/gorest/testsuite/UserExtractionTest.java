package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RestAssured.basePath = "/users";
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }

    //1. Extract the title
    @Test
    public void verifyallid() {
        List<Integer> allId = response.extract().path("id");
        System.out.println(allId);
    }

    //2. Extract the all Names
    @Test
    public void verifyallnames() {
        List<Integer> allnames = response.extract().path("name");
        System.out.println(allnames);
    }


    //3. Extract the name of 5th object
    @Test
    public void verifyfifthname() {
        List<Integer> names = response.extract().path("x[5].name");
        System.out.println(names);
    }

        //4. Extract the names of all object whose status = inactive
        @Test
        public void verifysatus() {
            List<HashMap<String, ?>> status = response.extract().path("findAll{it.status == 'inactive'}");
            System.out.println(status);
        }

        //5. Extract the gender of all the object whose status = active
        @Test
        public void verifysatusactive() {
            List<HashMap<String, ?>> status1 = response.extract().path("findAll{it.status == 'active'}");
            System.out.println(status1);
        }

        //6. Print the names of the object whose gender = female
        @Test
        public void printnameofgender() {
            List<String> female = response.extract().path("findAll{it.gender == 'female'}");
            System.out.println(female);
        }

        //7. Get all the emails of the object where status = inactive
        @Test
        public void allemailsinactive() {
            List<String> email = response.extract().path("findAll{it.status == 'inactive'}");
            System.out.println(email);
        }

        //8. Get the ids of the object where gender = male
        @Test
        public void allidsgender() {
            List<String> id = response.extract().path("findAll{it.gender == 'male'}");
            System.out.println(id);
        }

        //9. Get all the status
        @Test
        public void allstatus() {
        List<String> status = response.extract().path("status");
        System.out.println(status);
            }


        //10. Get email of the object where name = Karthik Dubashi IV
        @Test
        public void verifyemailofname() {
            List<String> email1 = response.extract().path("findAll{it.name == 'Karthik Dubashi IV'}");
            System.out.println(email1);
        }

        //11. Get gender of id = 5471
        @Test
        public void allid() {
            List<String> id1 = response.extract().path("findAll{it.id == 573700}.gender");
            System.out.println(id1);
        }

    }

