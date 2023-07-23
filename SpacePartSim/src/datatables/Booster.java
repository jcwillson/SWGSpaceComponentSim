package datatables;

public class Booster extends ShipComponent{

	private float fltCurrentEnergy, fltMaximumEnergyModifier, fltMaximumEnergy;
	private float fltRechargeRateModifier, fltRechargeRate;
	private float fltConsumptionRateModifier, fltConsumptionRate;
	private float fltAccelerationModifier, fltAcceleration;
	private float fltMaxSpeedModifier, fltMaxSpeed;
	public Booster(String line) 
	{
		String[] stats = line.split("\t",25);
		if(stats.length != 24)
		{
			System.out.println("Invalid source file");
			System.exit(-1);
		}
		strType = stats[0];
		strComments = stats[1];
		fltCurrentEnergy = Float.valueOf(stats[2]);
		fltMaximumEnergyModifier = Float.valueOf(stats[3]);
		fltMaximumEnergy = Float.valueOf(stats[4]);
		fltRechargeRateModifier = Float.valueOf(stats[5]);
		fltRechargeRate = Float.valueOf(stats[6]);
		fltConsumptionRateModifier = Float.valueOf(stats[7]);
		fltConsumptionRate = Float.valueOf(stats[8]);
		fltAccelerationModifier = Float.valueOf(stats[9]);
		fltAcceleration = Float.valueOf(stats[10]);
		fltMaxSpeedModifier = Float.valueOf(stats[11]);
		fltMaxSpeed = Float.valueOf(stats[12]);		
		fltCurrentHitpoints = Float.valueOf(stats[13]);
		fltMaximumHitpoints = Float.valueOf(stats[14]);
		fltMaximumArmorHitpointsMod = Float.valueOf(stats[15]);
		fltMaximumArmorHitpoints = Float.valueOf(stats[16]);
		fltCurrentArmorHitpoints = Float.valueOf(stats[17]);
		fltEfficiency = Float.valueOf(stats[18]);
		fltEnergyMaintenanceModifier = Float.valueOf(stats[19]);
		fltEnergyMaintenance = Float.valueOf(stats[20]);
		fltMassModifier = Float.valueOf(stats[21]);
		fltMass = Float.valueOf(stats[22]);
		reverseEngineeringLevel = Integer.valueOf(stats[23]);	
	}
	
	public float getFltCurrentEnergy()
	{
		return fltCurrentEnergy;
	}
	public float getFltMaximumEnergyModifier()
	{
		return fltMaximumEnergyModifier;
	}
	public float getFltMaximumEnergy()
	{
		return fltMaximumEnergy;
	}
	public float getFltRechargeRateModifier()
	{
		return fltRechargeRateModifier;
	}
	public float getFltRechargeRate()
	{
		return fltRechargeRate;
	}
	public float getFltConsumptionRateModifier()
	{
		return fltConsumptionRateModifier;
	}
	public float getFltConsumptionRate()
	{
		return fltConsumptionRate;
	}
	public float getFltAccelerationModifier()
	{
		return fltAccelerationModifier;
	}
	public float getFltAcceleration()
	{
		return fltAcceleration;
	}
	public float getFltMaxSpeedModifier()
	{
		return fltMaxSpeedModifier;
	}
	public float getFltMaxSpeed()
	{
		return fltMaxSpeed;
	}
}
