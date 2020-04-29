package bddTestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
public class RequestSpecificationTest {
	  RequestSpecification rspec;
	  RequestSpecBuilder build;
	  
	  @BeforeClass
	  public void requestSpec () {
	    
	    build = new RequestSpecBuilder();
	    build.setBaseUri ("https://maps.googleapis.com");
	    build.setBasePath ("maps/api/place/textsearch/json");
	    build.addParam ("query", "restaurants in mumbai");
	    build.addParam ("key", "XYZ");
	    
	    rspec = build.build ();

	 }
	  
	  @Test
	  public void test01 () {
	    
	         given()
	        .spec (rspec)
	        .when ()
	        .get ("")
	        .then ()
	        .contentType (ContentType.JSON)
	        .statusCode (200);
	  }

}
