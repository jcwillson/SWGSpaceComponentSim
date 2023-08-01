package datatables;

public class Shield extends ShipComponent {

	private float fltShieldRechargeRateModifier, fltShieldRechargeRate;
	private float fltShieldHitpointsMaximumFrontModifier, fltShieldHitpointsMaximumFront;
	private float fltShieldHitpointsMaximumBackModifier, fltShieldHitpointsMaximumBack;
	
	public Shield(String line)
	{
		String[] stats = line.split("\t",20);
		if(stats.length != 19)
		{
			System.out.println("Invalid source file");
			System.exit(-1);
		}
		strType = stats[0];
		strComments = stats[1];
		fltShieldRechargeRateModifier = Float.valueOf(stats[2]);
		fltShieldRechargeRate = Float.valueOf(stats[3]);
		fltShieldHitpointsMaximumFrontModifier = Float.valueOf(stats[4]);
		fltShieldHitpointsMaximumFront = Float.valueOf(stats[5]);
		fltShieldHitpointsMaximumBackModifier = Float.valueOf(stats[6]);
		fltShieldHitpointsMaximumBack = Float.valueOf(stats[7]);
		fltCurrentHitpoints = Float.valueOf(stats[8]);
		fltMaximumHitpoints = Float.valueOf(stats[9]);
		fltMaximumArmorHitpointsMod = Float.valueOf(stats[10]);
		fltMaximumArmorHitpoints = Float.valueOf(stats[11]);
		fltCurrentArmorHitpoints = Float.valueOf(stats[12]);
		fltEnergyMaintenanceModifier = Float.valueOf(stats[14]);
		fltEnergyMaintenance = Float.valueOf(stats[15]);
		fltMassModifier = Float.valueOf(stats[16]);
		fltMass = Float.valueOf(stats[17]);
		reverseEngineeringLevel = Integer.valueOf(stats[18]);
	}
	
	public float getFltShieldRechargeRateModifier()
	{
		return fltShieldRechargeRateModifier;
	}
	public float getFltShieldRechargeRate()
	{
		return fltShieldRechargeRate;
	}
	public float getFltShieldHitpointsMaximumFrontModifier()
	{
		return fltShieldHitpointsMaximumFrontModifier;
	}
	public float getFltShieldHitpointsMaximumFront()
	{
		return fltShieldHitpointsMaximumFront;
	}
	public float getFltShieldHitpointsMaximumBackModifier()
	{
		return fltShieldHitpointsMaximumBackModifier;
	}
	public float getFltShieldHitpointsMaximumBack()
	{
		return fltShieldHitpointsMaximumBack;
	}
}
