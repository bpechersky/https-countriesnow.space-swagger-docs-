package com.countriesnow.tests;

import com.countriesnow.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CitiesByCountryTest extends TestBase {

    @Test
    public void testCitiesByCountry() {
        given()
                .log().all()
                .redirects().follow(true)
                .queryParam("country", "Nigeria")
                .when()
                .get("/api/v0.1/countries/cities/q")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", not(empty()));
    }
}
