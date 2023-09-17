package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUseofJSONpath {

	@Test
	public void user() {
		//The base URI to be used
        RestAssured.baseURI = "https://reqres.in/api/users/";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
 
        //Makes calls to the server using Method type.
        Response response = httpRequest.request(Method.GET, "2");
        System.out.println("Body is"+response.body().asString());
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		
		String emailref = jsonPathEvaluator.get("data.email");

		// Print the email to see what we got
		System.out.println("email id is: " + emailref);

		// Validating the email
		Assert.assertEquals(emailref /* actual value */, "janet.weaver@reqres.in"/* Expected Value */,"Incorrect emailid");
	}
	
}
