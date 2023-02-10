package com.RestAssured;

import java.io.IOException;
import java.lang.reflect.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.RestAssured.utility.ReadDataFromPropFile;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC_02_ReqRes_Prop {

	@Test
	public void validateReqResTest() throws IOException {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		String actualContentType = response.header("Content-Type");
		String actualTransferEncoding = response.header("Transfer-Encoding");
		String actualXPoweredBy = response.header("X-Powered-By");
		String actualServer = response.header("Server");
		
		Assert.assertEquals(actualContentType, "application/json; charset=utf-8");
		Assert.assertEquals(actualTransferEncoding, "chunked");
		Assert.assertEquals(actualXPoweredBy, "Express");
		Assert.assertEquals(actualServer, "cloudflare");	
		
		ReadDataFromPropFile readData = new ReadDataFromPropFile();
		readData.getAll4Data();
		
		Headers allHeader = response.headers();
		
		for(Header header : allHeader) {
		System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
	}
}
