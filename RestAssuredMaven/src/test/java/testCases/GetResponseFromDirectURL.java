package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetResponseFromDirectURL {
	@Test
	void getUserDetails() {
	 
        //Makes calls to the server using Method type.
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        //Print the response body as string
        System.out.println("response body is"+response.getBody().asString());
        //Checks the Status Code
        int statusCode = response.getStatusCode();
        //validate the status is 200
        Assert.assertEquals(statusCode, 200);
        //print the comment
        System.out.println("Program 1 is successful");
}
}
