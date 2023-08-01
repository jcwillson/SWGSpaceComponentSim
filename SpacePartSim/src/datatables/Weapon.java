package datatables;

public class Weapon extends ShipComponent {

	private float fltMinDamageModifier, fltMinDamage;
	private float fltMaxDamageModifier, fltMaxDamage;
	private float fltShieldEffectivenessModifier, fltShieldEffectiveness;
	private float fltArmorEffectivenessModifier, fltArmorEffectiveness;
	private float fltEnergyPerShotModifier, fltEnergyPerShot;
	private float fltRefireRateModifier, fltRefireRate;
	
	public Weapon(String line)
	{
		String[] stats = line.split("\t",25);
		if(stats.length != 25)
		{
			System.out.println("Invalid source file");
			System.exit(-1);
		}
		strType = stats[0];
		strComments = stats[1];
		fltMinDamageModifier = Float.valueOf(stats[2]);
		fltMinDamage = Float.valueOf(stats[3]);
		fltMaxDamageModifier = Float.valueOf(stats[4]);
		fltMaxDamage = Float.valueOf(stats[5]);
		fltShieldEffectivenessModifier = Float.valueOf(stats[6]);
		fltShieldEffectiveness = Float.valueOf(stats[7]);
		fltArmorEffectivenessModifier = Float.valueOf(stats[8]);
		fltArmorEffectiveness = Float.valueOf(stats[9]);
		fltEnergyPerShotModifier = Float.valueOf(stats[10]);
		fltEnergyPerShot = Float.valueOf(stats[11]);
		fltRefireRateModifier = Float.valueOf(stats[12]);
		fltRefireRate = Float.valueOf(stats[13]);		
		fltCurrentHitpoints = Float.valueOf(stats[14]);
		fltMaximumHitpoints = Float.valueOf(stats[15]);
		fltMaximumArmorHitpointsMod = Float.valueOf(stats[16]);
		fltMaximumArmorHitpoints = Float.valueOf(stats[17]);
		fltCurrentArmorHitpoints = Float.valueOf(stats[18]);
		fltEnergyMaintenanceModifier = Float.valueOf(stats[20]);
		fltEnergyMaintenance = Float.valueOf(stats[21]);
		fltMassModifier = Float.valueOf(stats[22]);
		fltMass = Float.valueOf(stats[23]);
		reverseEngineeringLevel = Integer.valueOf(stats[24]);
	}
	
	public float getFltMinDamageModifier()
	{
		return fltMinDamageModifier;
	}
	public float getFltMinDamage()
	{
		return fltMinDamage;
	}
	public float getFltMaxDamageModifier()
	{
		return fltMaxDamageModifier;
	}
	public float getFltMaxDamage()
	{
		return fltMaxDamage;
	}
	public float getFltShieldEffectivenessModifier()
	{
		return fltShieldEffectivenessModifier;
	}
	public float getFltShieldEffectiveness()
	{
		return fltShieldEffectiveness;
	}
	public float getFltArmorEffectivenessModifier()
	{
		return fltArmorEffectivenessModifier;
	}
	public float getFltArmorEffectiveness()
	{
		return fltArmorEffectiveness;
	}
	public float getFltEnergyPerShotModifier()
	{
		return fltEnergyPerShotModifier;
	}
	public float getFltEnergyPerShot()
	{
		return fltEnergyPerShot;
	}
	public float getFltRefireRateModifier()
	{
		return fltRefireRateModifier;
	}
	public float getFltRefireRate()
	{
		return fltRefireRate;
	}
}
