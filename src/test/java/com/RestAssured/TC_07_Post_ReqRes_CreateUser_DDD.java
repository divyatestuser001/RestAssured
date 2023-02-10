package com.RestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class TC_07_Post_ReqRes_CreateUser_DDD {

	@Test(dataProvider = "smokeTestData")
    public void verifyCreateUserTest(String e_name, String e_role) {

        
        System.out.println("Name: " + e_name);
        System.out.println("ROLE: " + e_role);
        
        baseURI = "https://reqres.in";


        JSONObject request = new JSONObject();

        request.put("name", e_name);
        request.put("job", e_role);

        System.out.println("Request body: " + request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(request.toJSONString()).

                when().
                    post("/api/users").

                then().
                    statusCode(201).
                    body("name", equalTo(e_name)).
                    body("job", equalTo(e_role)).
                    log().all();

    }
    
    
    @DataProvider
    public Object [] [] smokeTestData() {
        
        
        Object [][] data = { {"Divya","Sr. Leader"}, {"Ashwath","Leader"}, {"Malli","Srm Manager"}};
        return data;
        
        
    }

	}

