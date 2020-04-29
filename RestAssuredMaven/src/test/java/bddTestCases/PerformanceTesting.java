package bddTestCases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class PerformanceTesting {
	
	//@Test
	public void testResponseTime()
	{
		long t = given().get("http://jsonplaceholder.typicode.com/photos/").time();
		System.out.println("time in milisecond is"+t);
	}
	
	//@Test
	public void testResponseTimeUnitSelection()
	{
		long t = given().get("http://jsonplaceholder.typicode.com/photos/1").timeIn(TimeUnit.SECONDS);
		System.out.println("time in seconds is"+t);
	}
	
	//@Test
	public void testResponseAssertion()
	{
		given().get("http://jsonplaceholder.typicode.com/photos/1").then().time(lessThan(50000L));
	}

}
