package com.countriesnow.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CountriesNowApiTest {

    @Test
    public void getAllCountries() {
        RestAssured
                .given()
                .accept(ContentType.ANY)
                .when()
                .get("https://countriesnow.space/api/v0.1/countries/")
                .then()
                .statusCode(200)
                .log().body()
                .body("error", equalTo(false))
                .body("msg", equalTo("countries and cities retrieved"))
                .body("data", not(empty()));
    }
}

