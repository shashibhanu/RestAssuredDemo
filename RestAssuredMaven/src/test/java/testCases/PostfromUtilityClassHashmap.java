package testCases;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.PostRandomData;

public class PostfromUtilityClassHashmap {
	public static HashMap map3 = new HashMap();
	@BeforeClass
	void postData()
	{
		map3.put("FirstName",PostRandomData.getFirstName());
		map3.put("LastName",PostRandomData.getLastName());
		map3.put("UserName",PostRandomData.getUserName());
		map3.put("Password",PostRandomData.getPassword());
		map3.put("Email",PostRandomData.getEmail());
		
	}

	
	
	
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


		// Add string form of JSON to the body of the request
		request.body(map3);

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
