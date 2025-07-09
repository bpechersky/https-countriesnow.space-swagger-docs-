package com.countriesnow;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://countriesnow.space";
        RestAssured.useRelaxedHTTPSValidation();
    }

}