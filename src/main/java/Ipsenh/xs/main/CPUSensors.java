package Ipsenh.xs.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.sensors.Temperature;

public class CPUSensors {
	
	private List<Boolean> checkList = new ArrayList<Boolean>();
	
			private boolean verifyAllEqualUsingHashSet(List<Boolean> checkList2) {
				//lmao 
	    return new HashSet<Boolean>(checkList2).size() <= 1;
	}
			
	public CPUSensors(Double maxTemp) {
		  Components components = JSensors.get.components();

		    List<Cpu> cpus = components.cpus;
		    if (cpus != null) {
		        for (final Cpu cpu : cpus) {
		            System.out.println("Found CPU component: " + cpu.name);
		            if (cpu.sensors != null) {
		              System.out.println("Sensors: ");
		  
		              //Print temperatures
		              List<Temperature> temps = cpu.sensors.temperatures;
		              for (final Temperature temp : temps) {
		                  Double cpuCoreTemp = temp.value;
		                  checkList.add(cpuCoreTemp<maxTemp);
		              }
		  
		            }
		        }
		    }
	}
	
	public boolean isCPUTooHot() {
		boolean result = !verifyAllEqualUsingHashSet(checkList);
		return result;
	}
	
	
}
