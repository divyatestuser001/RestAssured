package com.queryParam;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_01_Get_WeatherDetails_QueryParam2 {

	@Test
	public void verifyWeathterQueryParam() {
		baseURI = "http://api.openweathermap.org";
		String SearchCity = "Delhi";
		given().

		//?q=Delhi&appid=c76e6d1f2e6af75573c66176b1ad5627
		//header("Content-Type", "").
		params("q", SearchCity).
		params("appid", utility.Test.apiKey).
		//params("appid", "c76e6d1f2e6af75573c66176b1ad5627").
		when().

		get("/data/2.5/weather").
		then().

		statusCode(200).
		header("Server","openresty").
		header("Content-Type","application/json; charset=utf-8").
		body("weather[0].main",equalTo("Haze")).
		body("name",equalTo(SearchCity)).
		log().all();
	}
	
}
