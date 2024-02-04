package com.test.testClasses;

import com.java.utils.FrameworkConstants;
import com.java.utils.ReadProperties;
import com.java.wrapper.RestAPIWrapper;
import com.java.wrapper.RestClient;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestClientTest {

    private  static final Log log= LogFactory.getLog(RestClientTest.class);
    ReadProperties readProperties;
    @BeforeClass
    public void init() throws Exception {
        readProperties=new ReadProperties();
        RestClient.setBaseURI(readProperties.getValue("baseURI"));

    }

    @Test(priority = 0)
    public void getusers() throws Exception {
        RestClient.setBasePath(FrameworkConstants.BASEPATHUSERS);
        Response res=RestAPIWrapper.getResponseForListUsers();
        Assert.assertEquals(res.getStatusCode(),200);

    }

    @Test(priority = 1)
    public void createUsers() throws Exception {
        RestClient.setBasePath(FrameworkConstants.BASEPATHUSERS);
        Response res=RestAPIWrapper.getResponseForCreateUsers();
        Assert.assertEquals(res.getStatusCode(),201);

    }

    @Test(priority = 2)
    public void updateUsers() throws Exception {
        RestClient.setBasePath(FrameworkConstants.BASEPATHUPDATEUSERS);
        Response res=RestAPIWrapper.getResponseForUpdateUsers();
        Assert.assertEquals(res.getStatusCode(),200);
    }

}
