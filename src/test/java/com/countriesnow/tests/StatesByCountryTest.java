package com.countriesnow.tests;

import com.countriesnow.TestBase;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StatesByCountryTest extends TestBase {

    @Test
    public void testStatesByCountry() {
        given()
            .header("Content-Type", "application/json")
            .body("{ \"country\": \"India\" }")
        .when()
            .post("/api/v0.1/countries/states/")
        .then()
            .statusCode(200)
            .body("data.states", not(empty()));
    }
}