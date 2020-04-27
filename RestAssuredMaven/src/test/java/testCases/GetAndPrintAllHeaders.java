package testCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAndPrintAllHeaders {


	@Test
	public void user() {
		
		//The base URI to be used
        RestAssured.baseURI = "https://reqres.in/api/users/";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
 
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET, "2");
		// Get all the headers, return value is of type Headers.
		Headers allHeaders = response.getHeaders();
		// Headers class implements Iterable interface.
		// Iterate over all the Headers using an advance for loop as shown in the code below
		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}

	}
	

}
