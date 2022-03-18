package Ipsenh.onderzoek;

import java.util.HashMap;
import java.util.Map;

public class App {
    
    public static void main(String[] args) {
    	
    	System.out.println("Hell orld program");
    	
        //Set the timeout when waiting for command to terminate to 30 seconds instead of 10 (default value)
        Map<String, String> myConfig = new HashMap<>();
        myConfig.put("maxWait", args[1] );
    
		   try {
			Program program = new Program(Integer.parseInt(args[0]), 100 , myConfig);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
}
