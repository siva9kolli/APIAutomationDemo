package com.restassured.reqres.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetASingleUser {

    @Test
    public void getAUserData(){
        /*
        Given - path parameters, query parameters, headers related, body
        When - methods - Get, Post, Put, Patch, Delete
        Then - Validation, Assertions
         */

        Response response =
                when()
                        .get("https://reqres.in/api/users/2");

        System.out.println(response.asPrettyString());

        String userEmail =
                response
                        .then()
                        .extract()
                        .path("data.email");
        System.out.println("userEmail :: "+ userEmail);
        Assert.assertEquals(userEmail, "janet.weaver@reqres.in");
    }
}
