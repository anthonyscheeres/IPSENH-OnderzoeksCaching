package Ipsenh.onderzoek;

import java.util.Map;
import java.util.logging.Level;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;

public class CommandPowershell {

	String result;
	
	public CommandPowershell(String command,  Map<String, String> myConfig) {
		
		PowerShell powerShell = PowerShell.openSession();
		PowerShell session = powerShell.configuration(myConfig);
		PowerShellResponse response = session.executeCommand(command);
	    response.getCommandOutput();
	     
	      
	}
	
	public String getTime () {

		//System.out.println(result);
		
		if(result==null) {
			return null;
		}
		
		String[] split = result.split("\n");
		
		   String time = split[split.length -1];
		   
		   return time;
	}
	
}
