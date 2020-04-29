package bddTestCases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.*;

public class GetWeatherDetails {
	@Test
	void main()
	{
		given()
		.when()
		.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat()
		.body("City", equalTo("Hyderabad"))
		.header("Content-Type", equalTo("application/json"));
	}
}
