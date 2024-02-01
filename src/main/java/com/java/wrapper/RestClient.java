package com.java.wrapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestClient {

    public static void setBaseURI(String baseURI)
    {
        RestAssured.baseURI=baseURI;
    }

    public static void setBasePath(String basePath)
    {
        RestAssured.basePath=basePath;
    }
    
    public static  Response getMethod(Map<String,Integer> map)
    {
      Response res=null;
      RequestSpecification req=RestAssured.given().filter(new RestAssuredRequestFilter());
      res=req.queryParams(map).get().andReturn();
      return res;
    }

    public static  Response postMethod(String body)
    {
        Response res=null;
        RequestSpecification req=RestAssured.given().filter(new RestAssuredRequestFilter());
        res=req.contentType("application/json").body(body).post().andReturn();
        return res;
    }

    public static  Response putMethod(String body)
    {
        Response res=null;
        RequestSpecification req=RestAssured.given().filter(new RestAssuredRequestFilter());
        res=req.contentType("application/json").body(body).put().andReturn();
        return res;
    }
}
