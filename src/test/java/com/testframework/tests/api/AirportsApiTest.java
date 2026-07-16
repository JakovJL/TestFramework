package com.testframework.tests.api;

import com.testframework.core.BaseApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.notNullValue;

public class AirportsApiTest extends BaseApiTest {

    @Test
    public void getAllAirports() {
        given(requestSpec)
                .when()
                .get("/airports")
                .then()
                .statusCode(200)
                .body("data", not(emptyOrNullString()))
                .body("data.size()", equalTo(30))
                .body("data[0].id", notNullValue())
                .body("data[0].attributes.city", notNullValue())
                .body("links.next", notNullValue())
                .log().all();
    }

    @Test
    public void getAirportById() {
        given(requestSpec)
                .when()
                .get("/airports/KIX")
                .then()
                .statusCode(200)
                .body("data.id", equalTo("KIX"))
                .body("data.attributes.city", equalTo("Osaka"))
                .body("data.attributes.country", equalTo("Japan"))
                .log().all();
    }

    @Test
    public void getAirportByInvalidId() {
        given(requestSpec)
                .when()
                .get("/airports/ZZZZZ")
                .then()
                .statusCode(404)
                .body("errors[0].status", equalTo("404"))
                .body("errors[0].title", equalTo("Not Found"))
                .log().all();
    }
}