package com.testframework.core;

import com.testframework.config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseApiTest.class);

    private static final String EMAIL = "test@airportgap.com";
    private static final String PASSWORD = "airportgappassword";

    protected static RequestSpecification requestSpec;

    @BeforeClass(alwaysRun = true)
    public void setUpApi() {
        RestAssured.baseURI = ConfigReader.getApiBaseUrl();

        String token = RestAssured
                .given()
                .contentType(ContentType.URLENC)
                .formParam("email", EMAIL)
                .formParam("password", PASSWORD)
                .when()
                .post("/tokens")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .path("token");

        logger.info("Token obtained");

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getApiBaseUrl())
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer token=" + token)
                .build();
    }
}