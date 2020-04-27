package testCases;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.PostRandomData;

public class PostFromUtilityClass {
	
	
	
	@Test
	public void user() throws JSONException {
		
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		//RestAssured.basePath="/register";

		// Get the RequestSpecification of the request that you want to sent to the server
		// The server is specified by the BaseURI that we have specified in the above step
		RequestSpecification request = RestAssured.given();
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Create an object for JSONObject class
		JSONObject requestParams = new JSONObject();
		
		// We can add key-Value pairs using put method
		requestParams.put("FirstName", PostRandomData.getFirstName());
		requestParams.put("LastName", PostRandomData.getLastName());
		requestParams.put("UserName", PostRandomData.getUserName());
		requestParams.put("Password", PostRandomData.getPassword());
		requestParams.put("Email", PostRandomData.getEmail());

		// Add string form of JSON to the body of the request
		request.body(requestParams.toString());

		// Post the request and check the response
		Response response = request.post("/register");
		
		System.out.println("response body is"+response.getBody().asString());
		
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		
		String succCod = jsonPathEvaluator.get("SuccessCode");
		System.out.println(succCod);
		Assert.assertEquals(succCod, "OPERATION_SUCCESS");
	}

}
