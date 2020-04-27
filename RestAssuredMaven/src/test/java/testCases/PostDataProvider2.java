package testCases;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ExcelDataProvider;

public class PostDataProvider2 {
	
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
String [][] getData() throws IOException
{
	String path = "C:\\Drivers\\ShashiEclipseWorkspace\\RestAssuredMaven\\Data\\Postdata.xlsx";
	 int rownum = ExcelDataProvider.getRowCount(path, "Sheet1");
	 int colcount = ExcelDataProvider.getCellCount(path, "Sheet1",1);
     String[][] data = new String[rownum][colcount];
     for(int i=1;i<= rownum;i++)
     {
    	 for(int j=0;j<colcount;j++)
    	 {
    		 data[i-1][j]=ExcelDataProvider.getCellData(path, "Sheet1", i, j);
    	 }
     }
return(data);
}

}
