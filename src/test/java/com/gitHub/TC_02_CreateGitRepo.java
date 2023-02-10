package com.gitHub;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

//import com.RestAssured.utility.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TC_02_CreateGitRepo {

	@Test
	public void verifyListUserTest() {
		
		String repoName = "Divyaalakshmi";
		baseURI = "https://api.github.com";

		JSONObject request = new JSONObject();
		request.put("name", repoName);
		
		given().
		auth().
		oauth2(utility.Test.gitToken).
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		body(request.toJSONString()).
		
		when().
		post("/user/repos").
		
		then().
				statusCode(201).
				body("name", equalTo(repoName)).
				log().all();

	}
}
