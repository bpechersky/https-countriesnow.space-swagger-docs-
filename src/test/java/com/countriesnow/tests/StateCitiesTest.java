package com.countriesnow.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class StateCitiesTest {

    @Test
    public void getCitiesOfStateInCountry() {
        RestAssured
                .given()
                .relaxedHTTPSValidation()
                .queryParam("country", "Afghanistan")
                .queryParam("state", "Badakhshan")
                .when()
                .get("https://countriesnow.space/api/v0.1/countries/state/cities/q")
                .then()
                .statusCode(200)
                .log().body()
                .body("error", equalTo(false))
                .body("msg", containsString("retrieved"))
                .body("data", not(empty()));
    }
}
