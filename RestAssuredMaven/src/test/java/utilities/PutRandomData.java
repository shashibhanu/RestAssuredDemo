package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class PutRandomData {
	public static String getName()
	{
		String name = RandomStringUtils.randomAlphabetic(1);
		return ("Name"+name);
	}
	
	public static String getSalary()
	{
		String sal = RandomStringUtils.randomNumeric(5);
		return (sal);
	}
	
	public static String getAge()
	{
		String age = RandomStringUtils.randomNumeric(2);
		return (age);
	}

}
