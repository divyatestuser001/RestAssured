package com.gitHub;

import io.restassured.http.ContentType;

//import com.RestAssured.utility.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TC_03_Git_CreateUser{

	@Test
	public void verifyListUserTest() {
		
//		String repoName = "Rest Assured Automation";
		baseURI = "https://api.github.com";
		
		given().
//		auth().
//		oauth2(utility.Test.gitToken).
	
		when().
		get("/users/"+ utility.Test.gitUser + "/repos").
		then().

				statusCode(200)
				.log().all();

	
	
}
}