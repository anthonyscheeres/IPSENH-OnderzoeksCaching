package Ipsenh.onderzoek;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Program {
	   
	   Results result = new Results();
	   
	   //schone installatie
	   final String commandNormalCacheClean = "Remove-Item node_modules -Recurse -Force -Confirm:$false; yarn cache clean; time yarn install" ;
	   
	   
	   
//installeren aan de hand van een cache	   
	   final String commandNormal = "yarn install; Remove-Item node_modules -Recurse -Force -Confirm:$false; time yarn install" ;

	    
		   
		  //offline installatie aan de hand van een cache
		   final String commandNormalOffline = "yarn install; Remove-Item node_modules -Recurse -Force -Confirm:$false; time yarn install --offline" ;
		   

			  //bestaande dependencies, schone cache
				final String commandExistingNodeDependencies = "yarn install; yarn cache clean; time yarn install";
		

		   String[] commands = { commandNormalCacheClean, commandNormal, commandNormalOffline, commandExistingNodeDependencies};
		   
		   List<String> resultz = new ArrayList<String>();
	
	   public Program (int iterations, double maxTemp,   Map<String, String> myConfig) throws Exception {
		 
		   String[] ar = commands;
		   for (int index2iteration = 0; index2iteration < iterations; index2iteration++){
			   resultz = new ArrayList<String>();
		    for (int index = 0; index < ar.length; index++) {
		    	  
		    	  String result3 = "";
		    	  
	            // accessing each element of array
	            String commandx = ar[index];
	            CPUSensors sensor = new CPUSensors(maxTemp);
	            if (sensor.isCPUTooHot()) {
	            	throw new Exception("CPU is throttling");
	            }

	        	String[] cSplit = commandx.split("; ");
	       
			    for (int index3 = 0; index3 < cSplit.length; index3++) {
	            

		            System.out.println(cSplit[index3]);
	            
	            String result2 = new CommandPowershell(cSplit[index3], myConfig).getTime();
	            
	    
	           
	            if (cSplit.length -1 == index3) {
	            	result3 = result2;
	                System.out.println(result2);
	            }
	            
			    }
	            
	            resultz.add(result3);
	         
	            
	        }
		    
		    resultzToResul();
		    
	   }
		   String json = convertResultToJsonString();
		   System.out.println(json);
		   writeJson(json);
	   }
	
	   private void resultzToResul() {
		   result.SchoneInstallatie.add (resultz.get(0));
		   result.InstallerenAanDeHandVanEenCache.add (resultz.get(1));
		   result.OfflineInstallatieAanDeHandVanEenCache.add (resultz.get(2));
		   result.InstallatieSchoneCache.add ( resultz.get(3));
		   
	   }
	   

	   
	   private String currentDir() {
		   String userDirectory = FileSystems.getDefault()
			        .getPath("")
			        .toAbsolutePath()
			        .toString();
		   return userDirectory;
	   }
	   
	   
	   private void writeJson(String json) throws IOException {
		 
		    BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
		    writer.write(json);
		    
		    writer.close();
	   }
	   
	   
	   private String convertResultToJsonString(){

		   ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		   String json;
		try {
			json = ow.writeValueAsString(result);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		throw new Error("The conversion failed");
		
		   	}
	   
	   
}
