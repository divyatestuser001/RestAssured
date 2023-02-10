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

public class TC_03_Post_CreateUser_FileExample2_XML {

	String requestBody;

	@Test
	public void verifyCreateUserTest() throws Exception {
		
		baseURI = "http://dneonline.com/";

//app2 ---- get file 
		File file = new File(".\\data\\AddReqBody.xml");
		if (file.exists()) {
			System.out.println("File Exists......");
			FileInputStream fis = new FileInputStream(file);
			requestBody = IOUtils.toString(fis, "UTF-8");
			System.out.println(requestBody);
		}
		
		given().
//				header("Content-Type", "application/json").
				contentType("text/xml").
				accept(ContentType.XML).
				body(requestBody).
				
				
		when().
				post("/calculator.asmx").
				
		then().
		header("Content-Type", "text/xml; charset=utf-8").
				statusCode(200).
				and().
				body("//*:AddResult.text()", equalTo("24")).
				log().all();
	}	
	
}
