package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetStatcodeStatline {
	@Test
	void getUserDetails() {
		//The base URI to be used
        RestAssured.baseURI = "https://reqres.in/api/users/";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
 
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET, "2");
        //Print the response body as string
        System.out.println("response body is"+response.getBody().asString());
	    //To retrieve response status from the server and print the returned value.
	    int statusCode = response.getStatusCode();
		System.out.println("Status Code: "+statusCode );
		
		//To retrieve status line of the response from the server and print the returned value.
		String statusLine = response.getStatusLine();
		System.out.println("Status Line: "+statusLine );
	}


}
