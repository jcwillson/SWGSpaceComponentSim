/*
 * This is a dummy obj_id specifically to replace the one in source code in a simplified format.
 * The class implements specifically what variables/methods are needed for ship part generation.
 */

package modified;

import java.io.Serializable;

public class obj_id implements Comparable, Serializable{
	
	private final static long serialVersionUID = 84998777444285203L;
	
	private String shipComponentType = "";
	private String templateName;
	//General attributes
	private float componentMaximumArmorHitpoints, componentMass, componentEnergyMaintenance;
	//Booster specific attributes
	private float boosterMaximumEnergy, boosterEnergyRechargeRate, boosterEnergyConsumptionRate, boosterAcceleration, boosterMaximumSpeed;
	//Capacitor specific attributes
	private float weaponCapacitorMaximumEnergy, weaponCapacitorRechargeRate;
	//DI specific attributes
	private float droidInterfaceCommandSpeed;
	//Engine specific attributes
	private float engineMaximumSpeed, engineMaximumPitch, engineMaximumRoll, engineMaximumYaw;
	//Reactor specific attributes
	private float reactorEnergyGeneration;
	//Shield specific attributes
	private float shieldGeneratorMaximumFrontHitpoints, shieldGeneratorMaximumBackHitpoints, shieldGeneratorRechargeRate;
	//Weapon specific attributes
	private float weaponMinimumDamage, weaponMaximumDamage, weaponShieldEffectiveness, weaponArmorEffectiveness, weaponEnergyPerShot, weaponRefireRate;
	/*
	 * Initialize with component type and specific component string
	 * ie "booster","bst_subpro_accelatron_mk1"
	 */
	public obj_id(String comp, String temp)
	{
		shipComponentType = comp;
		templateName = temp;
	}

	//Accessors to give the type and component to space_crafting
	public String getShipComponentType()
	{
		return shipComponentType;
	}
	
	public String getTemplateName()
	{
		return templateName;
	}
	
	//Setters to store generated attributes
	
	//General attributes
	public void setComponentMaximumArmorHitpoints(obj_id x, float a)
	{
		componentMaximumArmorHitpoints = a;
	}
	public void setComponentMass(obj_id x, float a)
	{
		componentMass = a;
	}
	public void setComponentEnergyMaintenance(obj_id x, float a)
	{
		componentEnergyMaintenance = a;
	}

	//Booster attributes
	public void setBoosterMaximumEnergy(obj_id x, float a)
	{
		boosterMaximumEnergy = a;
	}
	public void setBoosterEnergyRechargeRate(obj_id x, float a)
	{
		boosterEnergyRechargeRate = a;
	}
	public void setBoosterEnergyConsumptionRate(obj_id x, float a)
	{
		boosterEnergyConsumptionRate = a;
	}
	public void setBoosterAcceleration(obj_id x, float a)
	{
		boosterAcceleration = a;
	}
	public void setBoosterMaximumSpeed(obj_id x, float a)
	{
		boosterMaximumSpeed = a;
	}
	
	//Capacitor attributes
	public void setWeaponCapacitorMaximumEnergy(obj_id x, float a)
	{
		weaponCapacitorMaximumEnergy = a;
	}
	public void setWeaponCapacitorRechargeRate(obj_id x, float a)
	{
		weaponCapacitorRechargeRate = a;
	}
	
	//DI attribute
	public void setDroidInterfaceCommandSpeed(obj_id x, float a)
	{
		droidInterfaceCommandSpeed = a;
	}
	
	//Engine attributes
	public void setEngineMaximumSpeed(obj_id x, float a)
	{
		engineMaximumSpeed = a;
	}
	public void setEngineMaximumPitch(obj_id x, float a)
	{
		engineMaximumPitch = a;
	}
	public void setEngineMaximumRoll(obj_id x, float a)
	{
		engineMaximumRoll = a;
	}
	public void setEngineMaximumYaw(obj_id x, float a)
	{
		engineMaximumYaw = a;
	}
	
	//Reactor attribute
	public void setReactorEnergyGeneration(obj_id x, float a)
	{
		reactorEnergyGeneration = a;
	}
	
	//Shield attributes
	public void setShieldGeneratorMaximumFrontHitpoints(obj_id x, float a)
	{
		shieldGeneratorMaximumFrontHitpoints = a;
	}
	public void setShieldGeneratorMaximumBackHitpoints(obj_id x, float a)
	{
		shieldGeneratorMaximumBackHitpoints = a;
	}
	public void setShieldGeneratorRechargeRate(obj_id x, float a)
	{
		shieldGeneratorRechargeRate = a;
	}
	
	//Weapon attributes
	public void setWeaponMinimumDamage(obj_id x, float a)
	{
		weaponMinimumDamage = a;
	}
	public void setWeaponMaximumDamage(obj_id x, float a)
	{
		weaponMaximumDamage = a;
	}
	public void setWeaponShieldEffectiveness(obj_id x, float a)
	{
		weaponShieldEffectiveness = a;
	}
	public void setWeaponArmorEffectiveness(obj_id x, float a)
	{
		weaponArmorEffectiveness = a;
	}
	public void setWeaponEnergyPerShot(obj_id x, float a)
	{
		weaponEnergyPerShot = a;
	}
	public void setWeaponRefireRate(obj_id x, float a)
	{
		weaponRefireRate = a;
	}
	/**
	 * Compares this to a generic object.
	 *
	 * @returns <, =, or > 0 if the object is a obj_id, else throws
	 *		ClassCastException
	 */
	public int compareTo(Object o) throws ClassCastException
	{
		return compareTo((obj_id)o);
	}	// compareTo(Object)

	/**
	 * Compares this to another obj_id.
	 *
	 * @returns <, =, or > 0
	 */
	public int compareTo(obj_id id)
	{
		if (id == null)
			return 1;
		return 0;
	}	// compareTo(obj_id)
	
	/*
	 * Generates a header line of the appropriate format for the module for the CSV output
	 */
	public String header()
	{
		String ret = "Armor,Mass,Energy Maintenance";
		switch(shipComponentType) {
			case "booster": {
				ret = ret.concat(",Max Energy,Recharge Rate, Consumption Rate, Acceleration, Maximum Speed");
				break;
			}
			case "capacitor": {
				ret = ret.concat(",Max Energy,Recharge Rate");
				break;
			}
			case "droid_interface": {
				ret = ret.concat(",Command Speed");
				break;
			}
			case "engine": {
				ret = ret.concat(",Top Speed,Pitch,Yaw,Roll");
				break;
			}
			case "reactor": {
				ret = ret.concat(",Generation");
				break;
			}
			case "shield": {
				ret = ret.concat(",Front Shield,BackShield,Recharge Rate");
				break;
			}
			case "weapon": {
				ret = ret.concat(",Min Damage,Max Damage,VSS,VSA,EPS,Refire");
				break;
			}
		}
		return ret.concat("\n");
	}
	
	/*
	 * CSV formatted output of calculated stats of this module
	 */
	@Override
	public String toString()
	{
		String ret = componentMaximumArmorHitpoints + "," + componentMass + "," + componentEnergyMaintenance;
		switch(shipComponentType) {
			case "booster": {
				ret = ret.concat("," + boosterMaximumEnergy + "," + boosterEnergyRechargeRate + "," + boosterEnergyConsumptionRate + "," + boosterAcceleration + "," + boosterMaximumSpeed);
				break;
			}
			case "capacitor": {
				ret = ret.concat("," + weaponCapacitorMaximumEnergy + "," + weaponCapacitorRechargeRate);
				break;
			}
			case "droid_interface": {
				ret = ret.concat("," + droidInterfaceCommandSpeed);
				break;
			}
			case "engine": {
				ret = ret.concat("," + engineMaximumSpeed + "," + engineMaximumPitch + "," + engineMaximumYaw + "," + engineMaximumRoll);
				break;
			}
			case "reactor": {
				ret = ret.concat("," + reactorEnergyGeneration);
				break;
			}
			case "shield": {
				ret = ret.concat("," + shieldGeneratorMaximumFrontHitpoints + "," + shieldGeneratorMaximumBackHitpoints + "," + shieldGeneratorRechargeRate);
				break;
			}
			case "weapon": {
				ret = ret.concat("," + weaponMinimumDamage + "," + weaponMaximumDamage + "," + weaponShieldEffectiveness + "," + weaponArmorEffectiveness + "," + weaponEnergyPerShot + "," + weaponRefireRate);
				break;
			}
		}
		ret = ret.concat("\n");
		return ret;
	}
}
