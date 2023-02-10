package com.gitHub;


import org.testng.annotations.Test;

//import com.RestAssured.utility.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_01_Get_GitHub {

	
	@Test
	public void verifyListUserTest() {
//	baseURI = "https://api.github.com";
	given().

	auth().
	//oauth2(Constants.git_token).
//	oauth2("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").
	oauth2(utility.Test.gitToken).
	when().
	get("https://api.github.com/user/repos").
	then().
	statusCode(200).
//	body("", equalTo("")).
	log().all();
	
}
}
