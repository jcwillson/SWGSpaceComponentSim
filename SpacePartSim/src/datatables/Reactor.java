package datatables;

public class Reactor extends ShipComponent {

	private float fltEnergyGenerationModifier, fltEnergyGeneration;
	
	public Reactor(String line)
	{
		String[] stats = line.split("\t",20);
		if(stats.length != 15)
		{
			System.out.println("Invalid source file");
			System.exit(-1);
		}
		strType = stats[0];
		strComments = stats[1];
		fltEnergyGenerationModifier = Float.valueOf(stats[2]);
		fltEnergyGeneration = Float.valueOf(stats[3]);		
		fltCurrentHitpoints = Float.valueOf(stats[4]);
		fltMaximumHitpoints = Float.valueOf(stats[5]);
		fltMaximumArmorHitpointsMod = Float.valueOf(stats[6]);
		fltMaximumArmorHitpoints = Float.valueOf(stats[7]);
		fltCurrentArmorHitpoints = Float.valueOf(stats[8]);
		fltEnergyMaintenanceModifier = Float.valueOf(stats[10]);
		fltEnergyMaintenance = Float.valueOf(stats[11]);
		fltMassModifier = Float.valueOf(stats[12]);
		fltMass = Float.valueOf(stats[13]);
		reverseEngineeringLevel = Integer.valueOf(stats[14]);
	}
	
	public float getFltEnergyGenerationModifier()
	{
		return fltEnergyGenerationModifier;
	}
	public float getFltEnergyGeneration()
	{
		return fltEnergyGeneration;
	}
}
