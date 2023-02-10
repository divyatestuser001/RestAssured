package com.RestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_03_UsingJsonPath {

	@Test
	public void verifyListTest() {

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

				body("data[0].email", equalTo("michael.lawson@reqres.in")).

				body("data[1].email", equalTo("lindsay.ferguson@reqres.in")).

				log().all();
	}
}
