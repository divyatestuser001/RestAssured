package com.exercise;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
//import io.restassured.internal.util.IOUtils;
//import utility.Constants; //import static io.restassured.RestAssured.*; 
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.io.FileHandler;

public class TC_03_Post_CreateUser_FileExample {

	String requestBody;

	@Test
	public void verifyCreateUserTest() throws Exception {
		
		baseURI = "https://reqres.in";
//app1
		JSONObject request = new JSONObject();
		request.put("name", "Divya");
		request.put("job", "Sr. QA Engineer");
		System.out.println("Request body: " + request.toJSONString());

//app2 ---- get file 
		File file = new File(".\\data\\createUserReqBody.json");
		if (file.exists()) {
			System.out.println("File Exists......");
			FileInputStream fis = new FileInputStream(file);
			requestBody = IOUtils.toString(fis, "UTF-8");
			System.out.println(requestBody);
		}
		
		given().
				header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				body(requestBody).
				
				
		when().
				post("/api/users").
				
		then().
				statusCode(201).
				body("name", equalTo("Divya")).
				body("job", equalTo("Sr. QA Engineer")).
				log().all();
	}
}