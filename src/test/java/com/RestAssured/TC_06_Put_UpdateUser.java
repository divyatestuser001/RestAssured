package com.RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_06_Put_UpdateUser {

	@Test
	public void verifyUpdateUserTest() {
		
		baseURI = "https://reqres.in";
		
		JSONObject request = new JSONObject();
		request.put("name", "Divya");
		request.put("job", "CEO");
		
		System.out.println("Request body: " + request.toJSONString());

		given().

				header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				body(request.toJSONString()).
				
		when().
				put("/api/users/2").
				
		then().
				statusCode(200).
				body("name", equalTo("Divya")).
				log().all();

	}
	
	
}
