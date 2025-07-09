package com.countriesnow.tests;

import com.countriesnow.TestBase;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CitiesByStateAndCountryTest extends TestBase {

    @Test
    public void testCitiesByStateAndCountry() {
        given()
            .header("Content-Type", "application/json")
            .body("{ \"country\": \"India\", \"state\": \"Maharashtra\" }")
        .when()
            .post("/api/v0.1/countries/state/cities/")
        .then()
            .statusCode(200)
            .body("data", not(empty()));
    }
}