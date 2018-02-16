package com.spronq.resttest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class AppTest {
    private boolean runTest;


    @BeforeClass
    public void initPath() {

        RestAssured.baseURI = "http://localhost:8080/service/message";
    }

    @BeforeTest
    public void setRunTest()
    {
        String directory = "/Users/edh/IdeaProjects/resttest/target/surefire-reports";
        runTest = new File(directory, "runTest.txt").exists();
    }

    @Test
    public void checkResponseCodeForCorrectRequest() {
        if (runTest)
            RestAssured.given().
                    when().
                    get().
                    then().
                    assertThat().
                    statusCode(200);
    }

    @Test
    public void checkResponseCodeForIncorrectRequest() {
        if (runTest)
            RestAssured.given().
                    when().
                    get("/err").
                    then().
                    assertThat().
                    statusCode(404);
    }

    @Test
    public void checkResponseContentTypeJson() {
        if (runTest)
            RestAssured.given().
                    when().
                    get().
                    then().assertThat().contentType("application/json");
    }

    @Test
    public void logResponseNames() {
        if (runTest)
            RestAssured.given().
                when().
                get().prettyPrint();
    }

    @Test
    public void checkNamesWithErr() {
        if (runTest)
            RestAssured.given().
                when().
                get().
                then().assertThat().body("[0].firstName", equalTo("Ed"))
                .and().assertThat().body("[0].lastName", equalTo("Zamani"));
    }

    @Test
    public void checkNames() {
        if (runTest)
            RestAssured.given().
                when().
                get().
                then().assertThat().body("[0].firstName", equalTo("Nabi"))
                .and().assertThat().body("[0].lastName", equalTo("Zamani"));
    }

}
