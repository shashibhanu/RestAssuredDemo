package bddTestCases;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import utilities.PutRandomData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PutDemo {
	//public static HashMap map2 = new HashMap();
	JSONObject requestParams;
	int empid = 21;
	@BeforeClass
	void putData()
	{
		/*map2.put("name",PutRandomData.getName());
		map2.put("salary",PutRandomData.getSalary());
		map2.put("age",PutRandomData.getAge());
		System.out.println(map2);*/
		 requestParams = new JSONObject();
		 requestParams.put("name",PutRandomData.getName());
		 requestParams.put("salary",PutRandomData.getSalary());
		 requestParams.put("age",PutRandomData.getAge());
		 System.out.println(requestParams);
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+empid;
		
	}

	@Test
	void putDemoMethod()
	{
		given()
		.contentType("application/json")
		.body(requestParams.toString())
		.when()
		.put()
		.then()
		.statusCode(200)
		.body("status", equalTo("success"))
		.log().all();
	

}

}
