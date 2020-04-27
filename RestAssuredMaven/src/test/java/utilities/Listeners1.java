package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners1 implements ITestListener {		

    		
    public void onStart(ITestContext result) {					
       				
        		System.out.println("Test Listening Started");
    }
    
    		
    public void onTestStart(ITestResult result) {					
    	{		
    	    System.out.println(result.getName()+" test case started");					
    	}	
        		
    }	

    		
    public void onTestSuccess(ITestResult result) {					
    	{		
    	    System.out.println("The name of the testcase passed is :"+result.getName());					
    	}
        		
    }	
    
    		
    public void onTestFailure(ITestResult result) {					
    	{		
    	    System.out.println("The name of the testcase failed is :"+result.getName());					
    	}
        		
    }
    
    		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        			
    	System.out.println("Debug the failure test cases");
    }	
    
    		
    public void onTestSkipped(ITestResult result) {					
        			
    	 {		
    		    System.out.println("The name of the testcase Skipped is :"+result.getName());					
         }
    }
    
			
    public void onFinish(ITestContext result) {					
				
		System.out.println("Test Listening finished");
    }
    
    	
}
