package com.java.wrapper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.pojo.Users;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
public class RestAPIWrapper {

    private  static final Log log= LogFactory.getLog(RestAPIWrapper.class);



    public static Response getResponseForListUsers()
    {
        Map<String,Integer> map=new HashMap<>();
        map.put("page",2);

        Response res=RestClient.getMethod(map);

        return res;



    }

    public static Response getResponseForCreateUsers() throws JsonProcessingException {

        Users user=new Users();
        user.setName("morpheus");
        user.setJob("leader");

        ObjectMapper mapper= new ObjectMapper() ;
        String s=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        log.info("body is ==="+s);

        Response res=RestClient.postMethod(s);

        return res;



    }

    public static Response getResponseForUpdateUsers() throws JsonProcessingException {

        Users user=new Users();
        user.setName("morpheus");
        user.setJob("zion resident");

        ObjectMapper mapper= new ObjectMapper() ;
        String s=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        log.info("body is ==="+s);

        Response res=RestClient.putMethod(s);

        return res;



    }





}
