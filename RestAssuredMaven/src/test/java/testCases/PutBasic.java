package testCases;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutBasic {
	Response response;
	
	@Test
	public void UpdateRecords(){
		 		 
		 RestAssured.baseURI ="http://jsonplaceholder.typicode.com/posts/1";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("userId", 1);
		 requestParams.put("id", 1);
		 requestParams.put("title", "updated title from shashi");
		 requestParams.put("body", "updated body from shashi");
		 
		 request.header("Content-Type", "application/json");
		 
		 request.body(requestParams.toString());
		 response = request.put();
		 System.out.println("response body is"+response.getBody().asString());
		 
		 
		 }
	
	
	@Test
	void validateStatusCode()
	{
		int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, 200); 
	}
	
	@Test
	void validateResponseBody()
	{
		JsonPath jsonPathEvaluator = response.jsonPath();
		String updatedtitle = jsonPathEvaluator.get("title");
		System.out.println("updated title is: " + updatedtitle);
		System.out.println("updated body is: " + jsonPathEvaluator.get("body"));
		Assert.assertEquals(updatedtitle /* actual value */, "updated title from shashi"/* Expected Value */,"Incorrect title");
		Assert.assertEquals(jsonPathEvaluator.get("body") /* actual value */, "updated body from shashi"/* Expected Value */,"Incorrect body");
	}
	
}
