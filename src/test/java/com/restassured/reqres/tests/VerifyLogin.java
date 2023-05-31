package com.restassured.reqres.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class VerifyLogin {

    String baseURL = "https://reqres.in";
    String loginResourcePath = "/api/login";


    /*
       Given - path parameters, query parameters, headers related, body
       When - methods - Get, Post, Put, Patch, Delete
       Then - Validation, Assertions
        */
    @Test
    public void verifyLoginAsUser() {
        HashMap loginCredentials = new HashMap();
        loginCredentials.put("email", "eve.holt@reqres.in");
        loginCredentials.put("password", "cityslicka");

        System.out.println("loginCredentials :: " + loginCredentials);

        Response response =
                given()
                        .contentType("application/json")
                        .body(loginCredentials)
                        .when()
                        .post(baseURL + loginResourcePath);


        System.out.println(response.asPrettyString());

        String token = response
                .then()
                .extract()
                .path("token");

        System.out.println("token" + token);


    }
}
