package Ipsenh.onderzoek;

import java.util.HashMap;
import java.util.Map;

public class App {
    
	
	
    public static void main(String[] args) {
    	
    	  //offline installatie aan de hand van een cache
 	   final String commandNormalOffline = 
 			   "yarn install; "
 	   		+ "Remove-Item node_modules -Recurse -Force -Confirm:$false; "
 	   		+ "time yarn install --offline  --silent --production=true" ;
 	   
 	  //offline installatie aan de hand van een cache
 	   final String commandNormalOfflineNPM = 
 			   "npm install --loglevel=error; "
 	   		+ "Remove-Item node_modules -Recurse -Force -Confirm:$false; "
 	   		+ "time npm --cache-min 9999999 --loglevel=error" ;
 	   
 	   
 	   
 	 
 	   
    	System.out.println("Helleworld program");
    	
        //Set the timeout when waiting for command to terminate to 30 seconds instead of 10 (default value)
        Map<String, String> myConfig = new HashMap<>();
        myConfig.put("maxWait", args[1] );
        int timeout = Integer.parseInt(args[0]);
        
		   try { 
			//new Program(timeout, 100 , myConfig, commandNormalOffline);
			new Program(timeout, 100 , myConfig, commandNormalOfflineNPM);
		} catch (Exception e) {
			//do nothing lol
		}

    }
    
}
