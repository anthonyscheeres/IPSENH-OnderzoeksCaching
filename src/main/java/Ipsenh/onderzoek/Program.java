package Ipsenh.onderzoek;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Program {
	   
	   Results result = new Results();
	   

		   
		  //offline installatie aan de hand van een cache
		   String commandNormalOffline;

		   List<String> resultz = new ArrayList<String>();
	
	   public Program (int iterations, double maxTemp,   Map<String, String> myConfig, String command, int timeBetweenCommands ) throws Exception {
		 
		   this.commandNormalOffline =  command; 
		   
		   for (int index2iteration = 1; index2iteration <= iterations; index2iteration++){
			   

               System.out.println(" --- Iteration Nr. ---");
               System.out.println(index2iteration);
			

	        	String[] cSplit = command.split("; ");
	       
	        	  String result2 = null ;
	        	
	        	   for (int index3 = 0; index3 < cSplit.length; index3++) {
	   	            

			            System.out.println(cSplit[index3]);			 
	            
			            
			            TimeUnit.SECONDS.sleep(timeBetweenCommands );   
			            
	            result2 = new CommandPowershell(cSplit[index3], myConfig).getTime();
	            
	            
			    }
	        	   System.out.println("Result: "+result2);
	        		  result.installatieAanDeHandVanEenCache.add (result2);
	   	           
	        	     
		         

	        	   
	       
	   }
		   
		    
	   

		   String json = convertResultToJsonString();
		   System.out.println(json);
		   writeJson(json);
		   
		   System.out.println(" --- End ---");
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
