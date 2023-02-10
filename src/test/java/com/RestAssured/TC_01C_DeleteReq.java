package com.RestAssured;

import io.restassured.http.ContentType;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TC_01C_DeleteReq {

	
	@Test
    public void verifyDeleteUserTest() {
        
        
        baseURI = "https://reqres.in";
        
        
        given().
        
        
        when().
            delete("/api/{users}/{id}", "users", 2).
            
        
        then(). 
            header("X-Powered-By", "Express").

            statusCode(204).
            log().all();
        
        
        
    }
}
