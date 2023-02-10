package com.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC_01_ReqRes {

	@Test
	public void validateReqResTest() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		String actualContentType = response.header("Content-Type");
		String actualTransferEncoding = response.header("Transfer-Encoding");
		String actualXPoweredBy = response.header("X-Powered-By");
		String actualServer = response.header("Server");
		
//		System.out.println("Content Type Header: " + actualContentType);
//		System.out.println("Transfer-Encoding: " + actualTransferEncoding);
//		System.out.println("X-Powered-By: " + actualXPoweredBy);
//		System.out.println("Server: " + actualServer);
		
		Assert.assertEquals(actualContentType, "application/json; charset=utf-8");
		Assert.assertEquals(actualTransferEncoding, "chunked");
		Assert.assertEquals(actualXPoweredBy, "Express");
		Assert.assertEquals(actualServer, "cloudflare");
		
		String values[] = {actualContentType, actualTransferEncoding, actualXPoweredBy, actualServer};
//		System.out.println("Headers: " + a);
		for(String value: values) {
			System.out.println(value);
		}		
		
		Headers allHeader = response.headers();
		
		for(Header header : allHeader) {
		System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
	}
}
