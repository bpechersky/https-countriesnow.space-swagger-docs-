package com.countriesnow.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class CountryCodesTest {

    @Test
    public void getAllCountryCodes() {
        RestAssured
                .given()
                .relaxedHTTPSValidation()
                .accept(ContentType.ANY)
                .when()
                .get("https://countriesnow.space/api/v0.1/countries/codes")
                .then()
                .statusCode(200)
                .log().body()
                .body("error", equalTo(false))
                .body("msg", containsString("retrieved"))
                .body("data", not(empty()));
    }
}
