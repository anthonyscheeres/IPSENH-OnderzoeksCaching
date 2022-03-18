package Ipsenh.xs.main;


public class Program {
	   
	   Results result = new Results();
	   
	   //schone installatie
	   final String commandNormalCacheClean = "Remove-Item node_modules; yarn cache clean; time yarn install" ;
	   
//installeren aan de hand van een cache	   
	   final String commandNormal = "yarn install; Remove-Item node_modules; time yarn install" ;

	   
		   
		  //offline installatie aan de hand van een cache
		   final String commandNormalOffline = "yarn install; Remove-Item node_modules; time yarn install --offline" ;
		   

			  //bestaande dependencies, schone cache
				final String commandExistingNodeDependencies = "yarn install; yarn cache clean; time yarn install";
		

		   String[] commands = { commandNormalCacheClean, commandNormal, commandNormalOffline, commandExistingNodeDependencies};
		   
		   
	
	   public Program (int iterations, double maxTemp) throws Exception {
		   String[] ar = commands;
		   for (int index2iteration = 0; index2iteration < iterations; index2iteration++){
		    for (int index = 0; index < ar.length; index++) {
		    	  
	            // accessing each element of array
	            String commandx = ar[index];
	            CPUSensors sensor = new CPUSensors(maxTemp);
	            if (sensor.isCPUTooHot()) {
	            	throw new Exception("CPU is throttling");
	            }
	            String result = new CommandPowershell(commandx).getTime();
	        }
	   }
		   
	   }
}
