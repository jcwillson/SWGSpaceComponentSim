package datatables;

public class Capacitor extends ShipComponent{
	
	private float fltCurrentEnergy, fltMaxEnergyModifier, fltMaxEnergy;
	private float fltRechargeRateModifier, fltRechargeRate;
	
	public Capacitor(String line) {
		String[] stats = line.split("\t",20);
		if(stats.length != 18)
		{
			System.out.println("Invalid source file");
			System.exit(-1);
		}
		strType = stats[0];
		strComments = stats[1];
		fltCurrentEnergy = Float.valueOf(stats[2]);
		fltMaxEnergyModifier = Float.valueOf(stats[3]);
		fltMaxEnergy = Float.valueOf(stats[4]);
		fltRechargeRateModifier = Float.valueOf(stats[5]);
		fltRechargeRate = Float.valueOf(stats[6]);		
		fltCurrentHitpoints = Float.valueOf(stats[7]);
		fltMaximumHitpoints = Float.valueOf(stats[8]);
		fltMaximumArmorHitpointsMod = Float.valueOf(stats[9]);
		fltMaximumArmorHitpoints = Float.valueOf(stats[10]);
		fltCurrentArmorHitpoints = Float.valueOf(stats[11]);
		fltEfficiency = Float.valueOf(stats[12]);
		fltEnergyMaintenanceModifier = Float.valueOf(stats[13]);
		fltEnergyMaintenance = Float.valueOf(stats[14]);
		fltMassModifier = Float.valueOf(stats[15]);
		fltMass = Float.valueOf(stats[16]);
		reverseEngineeringLevel = Integer.valueOf(stats[17]);
	}
	
	public float getFltCurrentEnergy()
	{
		return fltCurrentEnergy;
	}
	public float getFltMaxEnergyModifier()
	{
		return fltMaxEnergyModifier;
	}
	public float getFltMaxEnergy()
	{
		return fltMaxEnergy;
	}
	public float getFltRechargeRateModifier()
	{
		return fltRechargeRateModifier;
	}
	public float getFltRechargeRate()
	{
		return fltRechargeRate;
	}

}
