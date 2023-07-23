package datatables;

public class Armor extends ShipComponent{
	
	public Armor(String line)
	{
		String[] stats = line.split("\t",20);
		if(stats.length != 13)
		{
			System.out.println("Invalid source file");
			System.exit(-1);
		}
		strType = stats[0];
		strComments = stats[1];
		fltCurrentHitpoints = Float.valueOf(stats[2]);
		fltMaximumHitpoints = Float.valueOf(stats[3]);
		fltMaximumArmorHitpointsMod = Float.valueOf(stats[4]);
		fltMaximumArmorHitpoints = Float.valueOf(stats[5]);
		fltCurrentArmorHitpoints = Float.valueOf(stats[6]);
		fltEfficiency = Float.valueOf(stats[7]);
		fltEnergyMaintenanceModifier = Float.valueOf(stats[8]);
		fltEnergyMaintenance = Float.valueOf(stats[9]);
		fltMassModifier = Float.valueOf(stats[10]);
		fltMass = Float.valueOf(stats[11]);
		reverseEngineeringLevel = Integer.valueOf(stats[12]);
	}
	
	//Debug
	@Override
	public String toString()
	{
		return strType + "\t" + strComments + "\t" + fltCurrentHitpoints + "\t" + fltMaximumHitpoints + "\t" + fltMaximumArmorHitpointsMod;
	}

}
