/**
 * 
 */
package jJoules.energyDomain;

/**
 * @author sanoussy
 *
 */
public abstract class EnergyDomain {

	/**
	 * 
	 */
	public EnergyDomain() {
		
	}
	
	public abstract String getDeviceType();
	public abstract double getEneregyConsumed();
	/**
	 * @return domain name
	 */
	public abstract String getDomainName();

}
