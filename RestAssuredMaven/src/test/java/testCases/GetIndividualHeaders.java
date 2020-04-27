package testCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIndividualHeaders {

	@Test
	public void user() {
		
		//The base URI to be used
        RestAssured.baseURI = "https://reqres.in/api/users/";
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET, "2");
		// Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Content-Type"
    	String contentType = response.header("Content-Type");
    	System.out.println("Content-Type value: " + contentType);
        // Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Server"
    	String serverType =  response.header("Server");
    	System.out.println("Server value: " + serverType);
    	// Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Date"
	    String date = response.header("Date");
    	System.out.println("Date value: " + date);
        // Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Content-Encoding"
    	String contentEnco = response.header("Content-Encoding");
    	System.out.println("Content-Encoding: " + contentEnco);
    	// Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Transfer-Encoding"
    	String transferEnco = response.header("Transfer-Encoding");
    	System.out.println("Transfer-Encoding value: " + transferEnco);
    	
	}


}
