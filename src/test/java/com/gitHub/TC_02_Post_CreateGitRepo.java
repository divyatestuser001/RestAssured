package com.gitHub;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
//import utility;

public class TC_02_Post_CreateGitRepo {

	@Test
	public void verifyListUserTest() {

		String repoName = "RestAssured_API_Test";
		baseURI = "https://api.github.com";

		JSONObject request = new JSONObject();
		request.put("name", repoName);
		
		given()
		.auth()
		.oauth2(utility.Test.gitToken)
		.body(request.toJSONString())
		
		.when()
		.post("/user/repos").
		
		then().
				statusCode(201).
				body("name", equalTo(repoName)).
				log().all();
	}

}
