package Ipsenh.onderzoek;

import java.util.Map;

import com.profesorfalken.jpowershell.PowerShell;

public class CommandPowershell {

	String result;
	
	public CommandPowershell(String command,  Map<String, String> myConfig) {
		
		PowerShell powerShell = PowerShell.openSession();
		powerShell.configuration(myConfig);
		result = powerShell.executeSingleCommand(command).getCommandOutput();
		   
		   
	}
	
	public String getTime () {

		//System.out.println(result);
		
		String[] split = result.split("\n");
		
		   String time = split[split.length -1];
		   
		   return time;
	}
	
}
