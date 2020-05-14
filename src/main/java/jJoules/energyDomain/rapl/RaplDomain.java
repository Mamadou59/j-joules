/**
 * 
 */
package jJoules.energyDomain.rapl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import jJoules.energyDevice.rapl.RaplDevice;
import jJoules.energyDomain.EnergyDomain;

/**
 * @author sanoussy
 *
 */
public abstract class RaplDomain extends EnergyDomain {
	
	public static String RAPL_PATH_NAME = "/sys/devices/virtual/powercap/intel-rapl";
	
	private int socket;

	/**
	 * 
	 */
	public RaplDomain(int socket) {
		this.socket = socket;
	}
	
	public String getDeviceType() {
		return RaplDevice.class.getName();
	}
	public int getSocket() {
		return this.socket;
	}
	
	public String domainPath() {
		return  RaplDomain.RAPL_PATH_NAME;
	}
	
	public static String openAndReadFile(String pathName) {
		
		File file = new File(pathName);
		FileReader fr;
		String name = "";
		try {
			fr = new FileReader(file);
			name = new BufferedReader(fr).readLine();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public static boolean domainPathExist(String pathName) {
		return new File(pathName).exists();
	}
	
	public String toString() {
		return this.getDomainName()+"_"+this.getSocket();
	}
	
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o instanceof RaplDomain) {
			RaplDomain other = (RaplDomain) o;
			return this.toString().equals(other.toString());
		} return false;
	}
	
}
