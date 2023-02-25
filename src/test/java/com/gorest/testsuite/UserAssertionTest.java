package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class UserAssertionTest {
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

    //1.Verify the if the total record is 20
    @Test
    public void verifyTotalrecord() {
        List<String> Record = response.extract().path("url");
        Record.size();


    }
    //2. Verify the if the name of id = 576669is equal to ”Ujjwal Nehru MD”
    @Test
    public void verifynameofid(){
        response.body("find{it.id==576669}.name",equalTo("Ujjwal Nehru MD"));
    }
    //3. Check the single ‘Name’ in the Array list (Guru Trivedi)
    @Test
    public void verifysinglename(){
        response.body("name",hasItem("Guru Trivedi"));
    }
    @Test
    public void verifymultiname(){
        response.body("name",hasItems("Dayaamay Varma V","Brahmabrata Naik","Chandradev Saini"));
    }
    //5. Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void verifyemailofuserid(){
        response.body("find{it.id==576319}.email",equalTo("saini_chandradev@wyman.info"));
    }
   //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public  void verifystatus(){
        response.body("find{it.status=='active'}.name",equalTo("Brahmabrata Naik"));
    }
    //7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void verifygender(){
        response.body("find{it.gender=='male'}.name",equalTo("Chandradev Saini"));
    }



}