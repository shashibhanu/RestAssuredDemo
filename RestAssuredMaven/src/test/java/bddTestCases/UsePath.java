package bddTestCases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsePath {
	
	//@Test
	void main()
	{
		String refurl=
		given()
		.when()
		.get("http://jsonplaceholder.typicode.com/photos/1")
		.then()
		.contentType(ContentType.JSON)
		.body("title",equalTo("accusamus beatae ad facilis cum similique qui sunt"))
		.extract()
		.path("url");
		
		when().get(refurl).then().statusCode(200);
			
	}
	
	//@Test
	void differentWayJsonpath()
	{
		//String refurl1=get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");
		//System.out.println(refurl1);
		String refurl2=get("http://jsonplaceholder.typicode.com/photos/2").andReturn().jsonPath().getString("thumbnailUrl");
		System.out.println(refurl2);
		
		
	}
	
	
	
	//@Test
	void extractResponse()
	{
		Response response=when()
				.get("http://jsonplaceholder.typicode.com/photos/1")
				.then()
				.extract()
				.response();
		System.out.println(response);
		System.out.println("content type is"+response.contentType());
		System.out.println("url present in the body is"+response.path("url"));
		System.out.println("status code is"+response.statusCode());
		
		
	}
	

	//@Test
	public void sizeCheck() {
	        
	    given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}

	@Test
	public void Parameterizaion() {
	    
	    String originalText = "test";
	    String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6";
	        
	    given().
	        param("text",originalText).
	    when().
	        get("http://md5.jsontest.com").
	    then().
	        assertThat().
	        body("md5",equalTo(expectedMd5CheckSum));
	}
	
	@Test
	public void PathParameterization() {
	        
	    String season = "2017";
	    int numberOfRaces = 20;
	        
	    given().
	        pathParam("raceSeason",season).
	    when().
	        get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
	}
}
