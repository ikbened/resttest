package com.spronq.resttest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

/**
 * Created by edh on 02/03/2018.
 */
public class RestCountriesApiTest {

    @BeforeClass
    public void initPath() {

        RestAssured.baseURI = "https://restcountries.eu/rest/v2/name/";
    }

    @Test
    public void Name() {
        RestAssured.given().
                pathParam("name", "Nederland").
                when().
                get("/{name}").
                then().
                assertThat().statusCode(200)
                .and().assertThat().body("[0].capital", equalTo("Amsterdam"));
    }



}
