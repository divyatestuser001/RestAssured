package com.RestAssured;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class TC_05_Post_ReqRes_CreateUserTest {

	@Test
	public void verifyCreateUserTest() {
		baseURI = "https://reqres.in";
		JSONObject request = new JSONObject();
		request.put("name", "Divya");
		request.put("job", "CEO");
		System.out.println("Request body: " + request.toJSONString());

		given().
//oauth2(Constants.git_token).
//oauth2("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").
//body(DEFAULT_AUTH).
				header("Content-Type", "application/json").
//				contentType(ContentType.JSON).
				body(request.toJSONString()).
				
		when().
				post("/api/users").
				
		then().
				statusCode(201).
				body("name", equalTo("Divya")).
//body("", equalTo("")).
				log().all();

	}
}
