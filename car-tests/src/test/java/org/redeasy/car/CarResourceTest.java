package org.redeasy.car;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class CarResourceTest {

    @Test
    public void testGetCars() {
        given()
          .when().get("/cars")
          .then()
             .statusCode(200);
    }

    @Test
    public void testGetCarById() {
        given()
                .when().get("/cars/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetCarsHasItem() {
        given()
                .when().get("/cars")
                .then()
                .statusCode(200)
                .body("model", hasItem("BMW 525")) // si en campo modelo existe BMW 525
                .body("year", hasItems("2007", "2008"))
                .body("size()", is(3));

    }
}