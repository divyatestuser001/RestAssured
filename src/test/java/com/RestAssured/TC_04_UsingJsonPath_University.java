package com.RestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_04_UsingJsonPath_University {

	@Test
	public void verifyListTest() {

//		baseURI = "https://reqres.in";
//		Matcher univ1 = Matchers.equalTo("University of Petroleum and Energy Studies");
//		Matcher univ2 = Matchers.equalTo("DAV");
		given().when().get("http://universities.hipolabs.com/search?country=India").then().statusCode(200)
				.body("name[0]", equalTo("University of Petroleum and Energy Studies")).
//		.body("name[0]", univ1).
				body("name[1]", equalTo("DAV Institute of Engineering & Technology")).
//				body("name[1]", equalTo("DAV")).
//		body("name[1]", univ2).
				log().all();
//		Matcher test = Matchers.equalTo("");
	}
}
