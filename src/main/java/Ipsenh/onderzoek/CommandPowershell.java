package Ipsenh.onderzoek;

import com.profesorfalken.jpowershell.PowerShell;

public class CommandPowershell {

	String result;
	
	public CommandPowershell(String command) {
		 result = PowerShell.executeSingleCommand(command).getCommandOutput();
		   
		   
	}
	
	public String getTime () {

		   String time = result.split("\n")[result.lastIndexOf('-') + 1];
		   
		   return time;
	}
	
}
