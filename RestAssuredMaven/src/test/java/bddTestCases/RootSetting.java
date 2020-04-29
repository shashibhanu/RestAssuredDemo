package bddTestCases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class RootSetting {
	
	
	//Test without root
	//@Test
		public void testWithoutRoot()
		{
			given().
			get("https://reqres.in/api/users/2").
			then().
			statusCode(200).
			body("data.first_name",equalTo("Janet"));
		}
	
	//Test without root
	@Test
		public void testWithRoot()
		{
			given().
			get("https://reqres.in/api/users/2").
			then().
			root("data").
			body("first_name",equalTo("Janet"));
		}

}
