package com.countriesnow.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CountryCitiesTest {

    @Test
    public void getCitiesOfNigeria() {
        String payload = "{ \"country\": \"Nigeria\" }";

        RestAssured
                .given()
                .relaxedHTTPSValidation()
                .redirects().follow(false) // disable redirect following for debug
                .contentType(ContentType.JSON)
                .accept(ContentType.ANY)
                .body(payload)
                .when()
                .post("https://countriesnow.space/api/v0.1/countries/cities/")
                .then()
                .log().status()
                .log().headers()
                .log().body(); // do not assert .statusCode() here

    }
}
