package com.restassured.grocery.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetASingleProduct {

    String baseURL = "https://simple-grocery-store-api.glitch.me";
    String productsPath = "/products";

    @Test
    public void getStatus() {

        Response response =
                given().pathParam("productId", "8739")
                        .when().get(baseURL + productsPath + "/{productId}");
        System.out.println(response.asPrettyString());


    }
}
