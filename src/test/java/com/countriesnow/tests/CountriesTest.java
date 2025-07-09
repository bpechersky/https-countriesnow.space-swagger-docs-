package com.countriesnow.tests;

import com.countriesnow.TestBase;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class CountriesTest extends TestBase {

    @Test
    public void testGetAllCountries() {
        RestAssured
            .given()
            .when()
            .get("/api/v0.1/countries/")
            .then()
            .statusCode(200)
            .body("data", not(empty()));
    }
}