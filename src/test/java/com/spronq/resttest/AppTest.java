package com.spronq.resttest;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.hamcrest.Matchers.*;

public class AppTest {

    @BeforeClass
    public void initPath() {

        RestAssured.baseURI = "http://localhost:8080/service/message";
    }

    @Test
    public void checkResponseCodeForCorrectRequest() {
        RestAssured.given().
                when().
                get().
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void checkResponseCodeForIncorrectRequest() {
        RestAssured.given().
                when().
                get("/err").
                then().
                assertThat().
                statusCode(404);
    }

    @Test
    public void checkResponseContentTypeJson() {
        RestAssured.given().
                when().
                get().
                then().assertThat().contentType("application/json");
    }

    @Test
    public void logResponseNames() {
        RestAssured.given().
            when().
            get().prettyPrint();
    }

    @Test
    public void checkNamesWithErr() {
        RestAssured.given().
            when().
            get().
            then().assertThat().body("[0].firstName", equalTo("Ed"))
            .and().assertThat().body("[0].lastName", equalTo("Zamani"));
    }

    @Test
    public void checkNames() {
        RestAssured.given().
            when().
            get().
            then().assertThat().body("[0].firstName", equalTo("Nabi"))
            .and().assertThat().body("[0].lastName", equalTo("Zamani"));
    }
    
    @Test
    public void alwaysOK(){
        Assert.assertTrue(true);
    }


}
