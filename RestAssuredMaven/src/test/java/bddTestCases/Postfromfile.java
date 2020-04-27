package bddTestCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Postfromfile {
	
	@Test
	void registerCustomer()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
		File json = new File("C:\\Drivers\\ShashiEclipseWorkspace\\RestAssuredMaven\\Data\\jsonpostfiledata");
		Response resp = 
		given()
		.contentType("application/json")
		.log().all().body(json).post();
		resp.prettyPrint();
	

}

}
