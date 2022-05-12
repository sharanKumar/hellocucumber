package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiSupport {


    public void GET(String requestURI){
        Response response = RestAssured.get(requestURI);
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
    }

    public void POST(String requestURI , JSONObject requestBody){
        given().
                header("Content-type","application/json").
                contentType(ContentType.JSON).
                body(requestBody.toJSONString()).
                when().post(requestURI).
                then().statusCode(201).log().all();

    }

}
