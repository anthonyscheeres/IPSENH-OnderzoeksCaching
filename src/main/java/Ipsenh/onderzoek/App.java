package Ipsenh.onderzoek;

import java.util.HashMap;
import java.util.Map;

public class App {
    
	
	
    public static void main(String[] args) {
    	
    	
    	//time {yarn install -s >$null 2>&1 }
    	  //offline installatie aan de hand van een cache
 	   final String commandNormalOffline = 
 		
 	   		  "Remove-Item node_modules -Recurse -Force -Confirm:$false; "
 	   		+ "time { yarn install --offline -s >$null 2>&1 }" ;
 	   
 	  //offline installatie aan de hand van een cache
 	   final String commandNormalOfflineNPM = 
 			  
 	   		  "Remove-Item node_modules -Recurse -Force -Confirm:$false; "
 	   		+ "time { npm install --cache-min 9999999 --loglevel=error >$null 2>&1 }" ;
 	   
 	   
 	   
 	 
 	   
    	System.out.println("Helleworld program");
    	
        //Set the timeout when waiting for command to terminate to 30 seconds instead of 10 (default value)
        Map<String, String> myConfig = new HashMap<>();
        myConfig.put("maxWait", args[1] );
        int timeout = Integer.parseInt(args[0]);
        int timeBetweenCommands =Integer.parseInt(args[2]) ;
		   try { 
			//new Program(timeout, 100 , myConfig, commandNormalOffline);
			new Program(timeout, 100 , myConfig, commandNormalOfflineNPM, timeBetweenCommands );
		} catch (Exception e) {
			//do nothing lol
		}

    }
    
}
