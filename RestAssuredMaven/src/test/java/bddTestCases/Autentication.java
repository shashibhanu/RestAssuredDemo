package bddTestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
public class Autentication {
	
	//@Test
	public void test_APIWithBasicAuthentication() {
	        
	    given().
	        auth().
	        preemptive().
	        basic("username", "password").
	    when().
	        get("http://path.to/basic/secured/api").
	    then().
	        assertThat().
	        statusCode(200).and().log().body();
	}
	
	//@Test
	public void test_APIWithOAuth2Authentication() {
	        
	    given().
	        auth().
	        oauth2("YOUR_AUTHENTICATION_TOKEN_GOES_HERE").
	    when().
	        get("http://path.to/oath2/secured/api").
	    then().
	        assertThat().
	        statusCode(200).log().body();
	}

}
