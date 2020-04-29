package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AutherizationTest {
	@Test
	void user()
	{
    //logger.info("****************Autherization Test******************************");
	RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
	PreemptiveBasicAuthScheme authsch = new PreemptiveBasicAuthScheme();
	authsch.setUserName("ToolsQA");
	authsch.setPassword("TestPassword");
	RestAssured.authentication=authsch;
	
    
    //Define the specification of request. Server is specified by baseURI above.
    RequestSpecification httpRequest = RestAssured.given();

    //Makes calls to the server using Method type.
    Response response = httpRequest.request(Method.GET, "/");
    //Print the response body as string
    System.out.println("response body is"+response.getBody().asString());
    int statusCode = response.getStatusCode();
    //validate the status is 200
    Assert.assertEquals(statusCode, 200);
	
	}
}
