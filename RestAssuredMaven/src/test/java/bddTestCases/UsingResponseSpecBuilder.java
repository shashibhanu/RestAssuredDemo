package bddTestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class UsingResponseSpecBuilder {
	
	ResponseSpecification checkStatusCodeAndContentType = 
		    new ResponseSpecBuilder().
		        expectStatusCode(200).
		        expectContentType(ContentType.JSON).
		        build();
	
	@Test
	public void test_NumberOfCircuits_ShouldBe20_UsingResponseSpec() {
	        
	    given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().
	        spec(checkStatusCodeAndContentType).
	    and().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}

}
