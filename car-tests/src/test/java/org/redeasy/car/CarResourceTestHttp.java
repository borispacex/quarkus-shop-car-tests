package org.redeasy.car;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.redeasy.car.resource.CarResource;


import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class CarResourceTestHttp {

    @TestHTTPEndpoint(CarResource.class)
    @TestHTTPResource
    URL carEndpoint;

    @Test
    void testHttpGetCars() {
        given().contentType(ContentType.JSON)
                // .param("query", "Mustang")
                .when().get(carEndpoint)
                .then().statusCode(200)
                .body("model", hasItem("BMW 525"))
                .body("year", hasItems("2007", "2008"))
                .body("size()", is(3));
    }


}
