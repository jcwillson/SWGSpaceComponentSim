package datatables;

public class Engine extends ShipComponent {

	private float fltMaxSpeedModifier, fltMaxSpeed;
	private float fltMaxPitchModifier, fltMaxPitch;
	private float fltMaxRollModifier, fltMaxRoll;
	private float fltMaxYawModifier, fltMaxYaw;
	
	public Engine (String line)
	{
		String[] stats = line.split("\t",25);
		if(stats.length != 21)
		{
			System.out.println("Invalid source file");
			System.exit(-1);
		}
		strType = stats[0];
		strComments = stats[1];
		fltMaxSpeedModifier = Float.valueOf(stats[2]);
		fltMaxSpeed = Float.valueOf(stats[3]);
		fltMaxPitchModifier = Float.valueOf(stats[4]);
		fltMaxPitch = Float.valueOf(stats[5]);
		fltMaxRollModifier = Float.valueOf(stats[6]);
		fltMaxRoll = Float.valueOf(stats[7]);
		fltMaxYawModifier = Float.valueOf(stats[8]);
		fltMaxYaw = Float.valueOf(stats[9]);		
		fltCurrentHitpoints = Float.valueOf(stats[10]);
		fltMaximumHitpoints = Float.valueOf(stats[11]);
		fltMaximumArmorHitpointsMod = Float.valueOf(stats[12]);
		fltMaximumArmorHitpoints = Float.valueOf(stats[13]);
		fltCurrentArmorHitpoints = Float.valueOf(stats[14]);
		fltEnergyMaintenanceModifier = Float.valueOf(stats[16]);
		fltEnergyMaintenance = Float.valueOf(stats[17]);
		fltMassModifier = Float.valueOf(stats[18]);
		fltMass = Float.valueOf(stats[19]);
		reverseEngineeringLevel = Integer.valueOf(stats[20]);
	}
	
	public float getFltMaxSpeedModifier()
	{
		return fltMaxSpeedModifier;
	}
	public float getFltMaxSpeed()
	{
		return fltMaxSpeed;
	}
	public float getFltMaxPitchModifier()
	{
		return fltMaxPitchModifier;
	}
	public float getFltMaxPitch()
	{
		return fltMaxPitch;
	}
	public float getFltMaxRollModifier()
	{
		return fltMaxRollModifier;
	}
	public float getFltMaxRoll()
	{
		return fltMaxRoll;
	}
	public float getFltMaxYawModifier()
	{
		return fltMaxYawModifier;
	}
	public float getFltMaxYaw()
	{
		return fltMaxYaw;
	}
}
