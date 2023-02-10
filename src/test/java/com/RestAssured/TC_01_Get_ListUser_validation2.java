package com.RestAssured;

import org.testng.annotations.Test;

//import static io.restassured.RestAssured.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_01_Get_ListUser_validation2 {

@Test
public void verifyListUserTest() {
    
    
    baseURI = "https://reqres.in";
    
    
    given().
        //header
        //parameter
        //auth
        
    
    when().
        //action---sending a request ---get/post/put/delete etc....
        get("/api/users?page=2").
        
    
    then(). 
        //validation step
        //status code
        //value
        //header
        //JSON path
        statusCode(200).
        body("data[0].email",equalTo("michael.lawson@reqres.in")).
        body("data[1].email",equalTo("lindsay.ferguson@reqres.in")).
        body("data[2].email",equalTo("tobias.funke@reqres.in")).
        body("data[3].email",equalTo("byron.fields@reqres.in")).
        body("data[4].email",equalTo("george.edwards@reqres.in")).
        
        
        body("data.email",hasItems("michael.lawson@reqres.in", "george.edwards@reqres.in", "tobias.funke@reqres.in")).
        body("data.first_name",hasItems("Michael", "Lindsay")).
        
        log().all();

}
}