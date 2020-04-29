package testCases;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDataProvider1 {
	
	@Test(dataProvider="userdataprovider")
	public void user(String fname,String lname,String uname, String pasw, String email) throws JSONException {
		
		
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
		requestParams.put("FirstName", fname);
		requestParams.put("LastName", lname);
		requestParams.put("UserName", uname);
		requestParams.put("Password", pasw);
		requestParams.put("Email", email);

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
	
@DataProvider(name="userdataprovider")
String [][] getData()
{
String [][] data = {{"FNA6","LNA6","UNA6","PSA6","EMA6"},{"FNA6","LNA6","UNA6","PSA6","EMA6"}};
return(data);
}
}
