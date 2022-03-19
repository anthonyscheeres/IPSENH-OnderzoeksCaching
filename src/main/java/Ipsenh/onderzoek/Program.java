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
	   

		   
		  //offline installatie aan de hand van een cache
		   final String commandNormalOffline = "yarn install; Remove-Item node_modules -Recurse -Force -Confirm:$false; time yarn install --offline  --silent --production=true" ;
		   

		   List<String> resultz = new ArrayList<String>();
	
	   public Program (int iterations, double maxTemp,   Map<String, String> myConfig) throws Exception {
		 
		   for (int index2iteration = 1; index2iteration <= iterations; index2iteration++){
			   

               System.out.println(" --- Iteration Nr. ---");
               System.out.println(index2iteration);
			   
	            CPUSensors sensor = new CPUSensors(maxTemp);
	            if (sensor.isCPUTooHot()) {
	            	throw new Exception("CPU is throttling");
	            }

	        	String[] cSplit = commandNormalOffline.split("; ");
	       
	        	   for (int index3 = 0; index3 < cSplit.length; index3++) {
	   	            

			            System.out.println(cSplit[index3]);			 
	            
	            String result2 = new CommandPowershell(cSplit[index3], myConfig).getTime();
	            
	            
	            if (cSplit.length -1 == index3) {
	            	
	            	  result.OfflineInstallatieAanDeHandVanEenCache.add (result2);
	            	
	                System.out.println(result2);
	            }
	            
			    }
	        	   
	        	     
		         

	        	   
	       
	   }
		   
		    
	   

		   String json = convertResultToJsonString();
		   System.out.println(json);
		   writeJson(json);
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
