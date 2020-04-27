package bddTestCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteDemo {
	
	@Test
	void deleteMethod()
	{
	
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/9";
		given()
		.when()
		.delete()
		.then()
		.statusCode(200)
		.body("status", equalTo("success"))
		.body("message", equalTo("successfully! deleted Records"))
		.log().all();
		//.body("data.employee_name", equalTo("rahul"));
	

}


}
