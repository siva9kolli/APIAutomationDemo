package com.restassured.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class GetStatus {
    String baseURL = "https://simple-grocery-store-api.glitch.me";
    String statusPath = "/status";

    @Test
    public void getStatus(){

        Response response =
        when().get(baseURL + statusPath);

        String statusValue =
        response.then().extract().path("status");

        System.out.println("statusValue :: " + statusValue);
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());

        Assert.assertEquals(statusValue, "UP");
        Assert.assertEquals(response.statusCode(), 200);
    }
}
