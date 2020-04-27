package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class PostRandomData {
	public static String getFirstName()
	{
		String genfirstname = RandomStringUtils.randomAlphabetic(1);
		return ("FN"+genfirstname);
	}
	
	public static String getLastName()
	{
		String genlastname = RandomStringUtils.randomAlphabetic(2);
		return ("LN"+genlastname);
	}
	
	public static String getUserName()
	{
		String genusername = RandomStringUtils.randomAlphabetic(3);
		return ("UN"+genusername);
	}
	
	public static String getPassword()
	{
		String genpassword = RandomStringUtils.randomAlphabetic(3);
		return ("PA"+genpassword);
	}
	
	public static String getEmail()
	{
		String genemail = RandomStringUtils.randomAlphabetic(3);
		return ("EM"+genemail);
	}

}
