package datatables;

public class DroidInterface extends ShipComponent{
	
	private float fltCommandSpeedModifier, fltCommandSpeed;
	
	public DroidInterface(String line)
	{
		String[] stats = line.split("\t",20);
		if(stats.length != 15)
		{
			System.out.println("Invalid source file");
			System.out.println(stats.toString());
			System.exit(-1);
		}
		strType = stats[0];
		strComments = stats[1];
		fltCommandSpeedModifier = Float.valueOf(stats[2]);
		fltCommandSpeed = Float.valueOf(stats[3]);		
		fltCurrentHitpoints = Float.valueOf(stats[4]);
		fltMaximumHitpoints = Float.valueOf(stats[5]);
		fltMaximumArmorHitpointsMod = Float.valueOf(stats[6]);
		fltMaximumArmorHitpoints = Float.valueOf(stats[7]);
		fltCurrentArmorHitpoints = Float.valueOf(stats[8]);
		fltEfficiency = Float.valueOf(stats[9]);
		fltEnergyMaintenanceModifier = Float.valueOf(stats[10]);
		fltEnergyMaintenance = Float.valueOf(stats[11]);
		fltMassModifier = Float.valueOf(stats[12]);
		fltMass = Float.valueOf(stats[13]);
		reverseEngineeringLevel = Integer.valueOf(stats[14]);
	}
	
	public float getFltCommandSpeedModifier()
	{
		return fltCommandSpeedModifier;
	}
	public float getFltCommandSpeed()
	{
		return fltCommandSpeed;
	}
}
