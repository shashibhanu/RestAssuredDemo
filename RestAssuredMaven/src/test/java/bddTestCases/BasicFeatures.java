package bddTestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.*;

import io.restassured.RestAssured;

public class BasicFeatures {
	
	//testing status code
	//@Test
	public void testStatCode()
	{
		given().
		get("http://jsonplaceholder.typicode.com/posts/3").
		then().
		statusCode(200);
	}
	
	//logging body in console
	//@Test
	public void testLogging()
	{
		given().
		get("http://jsonplaceholder.typicode.com/posts/3").
		then().
		statusCode(200).
		log().body();
	}
	
	//logging all in console
	//@Test
		public void testLoggingAll()
		{
			given().
			get("http://jsonplaceholder.typicode.com/posts/3").
			then().
			statusCode(200).
			log().all();
		}
		
		//Test Equal to function 
		//@Test
			public void testEqualTo()
			{
				given().
				get("https://reqres.in/api/users/2").
				then().
				statusCode(200).
				body("data.first_name",equalTo("Janet"));
			}
			
			//Test Equal to function 
			//@Test
				public void testHasFunction()
				{
					given().
					get("https://reqres.in/api/users/").
					then().
					statusCode(200).
					body("data.first_name",hasItems("Janet","George","Emma"));
				}
				
				//sending parameters
				//@Test
					public void sendParam()
					{
						given().
						param("key1","value1").
						header("head1","value1").
						get("http://jsonplaceholder.typicode.com/posts/3").
						then().
						statusCode(200).
						log().all();
					}
					
					//sending parameters
					@Test
						public void anuredFeat()
						{
							given().param("key1","value1").and().header("head1","value1").get("http://jsonplaceholder.typicode.com/posts/3").then().statusCode(200).and().log().all();
					    }


}
