package commonPackage;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerClass {
	public static Logger logger;
	
	
	public static void setup()
	{
		logger = logger.getLogger("RestAssuredLoggerDemo");
		PropertyConfigurator.configure("Log4j2.properties");
		logger.setLevel(Level.DEBUG);
		
	}

}
