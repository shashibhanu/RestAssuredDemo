package testCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetReadfromExcel {
	@Test
	public void f() throws IOException {

		// Create a reference for Response interface
		Response response;

		// Path from where the excel file has to be read
		String path = "C:\\Drivers\\ShashiEclipseWorkspace\\RestAssuredMaven\\Data\\Getdata.xlsx";

		// File input stream which needs the input as the file location
		FileInputStream fis = new FileInputStream(path);

		// Workbook reference of the excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Sheet which needs to be accessed from within the workbook
		XSSFSheet sheet = wb.getSheetAt(0);

		// Count the number of rows
		int rowCount = sheet.getLastRowNum();

		// Iterate the AccountNumber
		for (int i = 0; i <= rowCount; i++) {

			// Pass the row number and the cell number from where the value has to be
			// fetched
			DataFormatter formatter = new DataFormatter();
			//to solve the issue cannot get a string value from a numeric cell, DataFormatter is used
			
			String id = formatter.formatCellValue(sheet.getRow(i).getCell(0));
			// Make a request to the server by specifying the method Type and the method
			// URL.
			// This will return the Response from the server. Store the response in a
			// reference variable created above.
			response = RestAssured
					.get("https://reqres.in/api/users/"+ id);
			// print the message body of the response received from the server
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
		}
	}

}
