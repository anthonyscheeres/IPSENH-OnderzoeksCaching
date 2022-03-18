package Ipsenh.onderzoek;

import com.profesorfalken.jpowershell.PowerShell;

public class CommandPowershell {

	String result;
	
	public CommandPowershell(String command) {
		 result = PowerShell.executeSingleCommand(command).getCommandOutput();
		   
		   
	}
	
	public String getTime () {

		String[] split = result.split("\n");
		
		   String time = split[split.length - 1];
		   
		   return time;
	}
	
}
