package com.restassured.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetAllProducts {
    String baseURL = "https://simple-grocery-store-api.glitch.me";
    String statusPath = "/products";

    @Test
    public void getStatus(){

        Response response =
        when().get(baseURL + statusPath);

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
