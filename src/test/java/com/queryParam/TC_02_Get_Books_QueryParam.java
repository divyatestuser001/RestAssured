package com.queryParam;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_02_Get_Books_QueryParam {

	@Test
	public void verifyWeathterQueryParam() {
		baseURI = "https://demoqa.com/";
		String title = "Git Pocket Guide";
		
		given().
		queryParam("ISBN", "9781449325862").

		when().
		get("BookStore/v1/Book").

		then().
		statusCode(200).
		body("subTitle",equalTo("A Working Introduction")).
		body("title",equalTo(title)).
		log().all();
	}
	
}
