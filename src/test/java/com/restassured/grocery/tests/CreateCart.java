package com.restassured.grocery.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CreateCart {
    String baseURL = "https://simple-grocery-store-api.glitch.me";
    String statusPath = "/carts";


    public String getCartId() {

        Response response =
                when().post(baseURL + statusPath);

        System.out.println("response :: " + response.asPrettyString());

        String cartId = response
                .then().extract()
                .path("cartId");

        System.out.println("cartId :: " + cartId);
        return cartId;
    }

    @Test
    public void getACart() {

        String cartIdValue = getCartId();
        Response response =
                given().pathParam("cartId", cartIdValue)
                        .when().get(baseURL + statusPath + "/{cartId}");

        System.out.println("response :: " + response.asPrettyString());

    }
}
