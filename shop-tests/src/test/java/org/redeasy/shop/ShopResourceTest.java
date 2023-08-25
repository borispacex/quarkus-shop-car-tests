package org.redeasy.shop;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ShopResourceTest {

    @Test
    public void testGetShops() {
        given()
                .when().get("/shops")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetShopById() {
        given()
                .when().get("/shops/1")
                .then()
                .statusCode(200);
    }

    /*
     * Crear un test para validar que el retorno del metodo getAll() en ShopResource retorna dos entidades Shop.
     */
    @Test
    public void testGetShopsTwoSize() {
        given()
                .when().get("/shops")
                .then()
                .statusCode(200)
                .body("size()", is(2));
    }
    /*
     * En el ejercicio validar el codigo de estado verificar el codigo 200 de retorno y que el nombre de state en al menos uno de ellos sea Ohio
     */
    @Test
    public void testGetShopsStateOhio() {
        given()
                .when().get("/shops")
                .then()
                .statusCode(200)
                .body("state", hasItem("Ohio"));
    }
}