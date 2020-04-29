package bddTestCases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class BasicFeaturesXml {
	
	//Test single body content 
			//@Test
				public void testSingleContent()
				{
					given().
					get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
					then().
					statusCode(200).
					body("CUSTOMER.ID",equalTo("10")).
					log().all();
				}
				
				//Test multiple body content 
				//@Test
					public void testMultipleContent()
					{
						given().
						get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
						then().
						statusCode(200).
						body("CUSTOMER.ID",equalTo("10")).
						body("CUSTOMER.FIRSTNAME",equalTo("Sue")).
						body("CUSTOMER.LASTNAME",equalTo("Fuller")).
						body("CUSTOMER.STREET",equalTo("135 Upland Pl.")).
						body("CUSTOMER.CITY",equalTo("Dallas")).
						log().all();
					}
					
					//Test complete body in one go 
					//@Test
						public void testCompleteBody()
						{
							given().
							get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
							then().
							statusCode(200).
							body("CUSTOMER.text()",equalTo("10SueFuller135 Upland Pl.Dallas")).
							log().all();
						}
					
					//Test with the help of xpath 
					//@Test
					public void testXpath()
					{
						given().
						get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
						then().
						statusCode(200).
						body(hasXPath("/CUSTOMER/LASTNAME",containsString("Fuller"))).
						log().all();
					}
					
					

}
