package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PostsAssertionTest {
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
    //1. Verify the if the total record is 25
    @Test
    public void verifytotal(){
        List<String> Record = response.extract().path("url");
        Record.size();

    }

    //2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demittocentum.”
    @Test
    public void verifynameofid(){
        response.body("find{it.id==20733}.title",equalTo("Cibo temperantia talus certo beatus victus coerceo clarus volup confero velit super viridis."));
    }


    //3. Check the single user_id in the Array list (5522)

    @Test
    public void verifysingleuser(){
        response.body("user_id",hasItem(580267));
    }

    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
@Test
    public void verifymultipleids(){
    response.body("user_id",hasItems(580267,576669,578139));
}


    //5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcarspectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco etantiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequuscuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undiqueadflicto. Assentator umquam pel."”
    @Test
    public void verifybody() {
        response.body("find{it.user_id == 580267}.body", equalTo("Est viduata tego. Condico cimentarius suasoria. Tero auris caritas. Appositus decimus volva. Ratione dolores cenaculum. Vitiosus celo vox. Charisma paens administratio. Allatus utrum comburo. Solus accipio volubilis. Anser taedium quia. Cauda infit via. Velum ait utrum. Vigilo quis quia. Arcus capio subvenio. Impedit vereor ea. Argentum aequus molestiae. Dolorum tubineus est."));
    }
}

