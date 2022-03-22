package Ipsenh.onderzoek;

import java.util.Map;


import com.profesorfalken.jpowershell.PowerShell;

public class CommandPowershell {

	String result;
	
	public CommandPowershell(String command,  Map<String, String> myConfig) {
		
		PowerShell powerShell = PowerShell.openSession();
		PowerShell session = powerShell.configuration(myConfig);
		result = session.executeCommand(command).getCommandOutput();

	     
	      
	}
	
	public String getTime () {
		
		if(result==null) {
			return result;
		}
		
		String[] split = result.split("\n");
		
		   String time = split[split.length -1];
		   
		   return time;
	}
	
}
