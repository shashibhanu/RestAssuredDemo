package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAssertions {
	
	
	@Test
	  public void user() {
		
		//The base URI to be used
        RestAssured.baseURI = "https://reqres.in/api/users/";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
 
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET, "2");
        
		//Validating STATUS CODE from response
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "INCorrect status code returned");
		
		//Assert status code not null flavor
		Assert.assertNotNull(response.getStatusCode(),"status code is Null");
		
		//Validating STATUS LINE from response
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "INCorrect status Line returned");
		
		//Validating CONTENT TYPE from response
		String contentType = response.getContentType();
		Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
		
		//Validating text from response
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("Janet") /*Expected value*/, true /*Actual Value*/, "Response body does not contain martin");
		Assert.assertEquals(responseBody.toLowerCase().contains("janet") /*Expected value*/, true /*Actual Value*/, "Response body does not contain martin");
		
		

	}



}
