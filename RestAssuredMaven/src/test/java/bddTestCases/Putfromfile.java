package bddTestCases;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Putfromfile {
	
	@Test
	void registerCustomer()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/2";
		File json = new File("C:\\Drivers\\ShashiEclipseWorkspace\\RestAssuredMaven\\Data\\jsonputfiledata");
		Response resp = 
		given()
		.contentType("application/json")
		.log().all().body(json).put();
		resp.prettyPrint();
	

}

}
