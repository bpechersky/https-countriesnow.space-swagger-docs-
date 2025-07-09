package com.countriesnow.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountryCodeLookupTest {

    @Test
    public void getNigeriaIsoCodesFromList() {
        List<Map<String, String>> countries = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .accept(ContentType.JSON)
                .when()
                .get("https://countriesnow.space/api/v0.1/countries/codes")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .jsonPath()
                .getList("data");

        Map<String, String> nigeria = countries.stream()
                .filter(c -> "Nigeria".equalsIgnoreCase(c.get("name")))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nigeria not found"));

        assertThat(nigeria.get("code"), equalTo("NG"));         // ISO2
        assertThat(nigeria.get("dial_code"), equalTo("+234"));  // Optional: validate phone code
    }
}
