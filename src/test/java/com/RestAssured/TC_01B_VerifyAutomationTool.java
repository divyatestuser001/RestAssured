package com.RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_01B_VerifyAutomationTool {

	@Test
    public void verifyRestAssuredTest() {
        
        //https://run.mocky.io/v3/55889581-da52-4383-840e-bdf6dde19252
        baseURI = "https://run.mocky.io";
        
        
        given().
            //header
            //header("Content-Type", "application/json").
            
        
        when().
            get("/v3/f82f4653-97f6-4b10-9d97-fad3c0696347").
//            https://run.mocky.io/v3/e80ec94b-8d07-486d-9c76-3c6fb33d13f0
        
        then().
            statusCode(200).
            header("Content-Type", "application/xml; charset=UTF-8").
            body("courses.subject.name",hasItems("Selenium", "Rest Assured", "Java", "WebDriver IO")).
            body("courses.subject.price",hasItems("12", "10", "20", "10")).
            log().all();
        
        
        
        
    }
	
}
