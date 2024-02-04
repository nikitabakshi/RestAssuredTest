package com.java.wrapper;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RestAssuredRequestFilter implements Filter {
    private  static final Log log= LogFactory.getLog(RestAssuredRequestFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response res=ctx.next(requestSpec,responseSpec);
        log.info(requestSpec.getMethod() +" "+requestSpec.getURI() +"\n Request Body =>" + requestSpec.getBody() +"\n"
                + res.getStatusCode()+" "+res.getStatusLine() + "\n Response Body =>" + res.getBody().prettyPrint());
        return res;
    }
}
