package datatables;

public abstract class ShipComponent {
	protected String strType, strComments;
	protected float fltCurrentHitpoints, fltMaximumHitpoints;
	protected float fltMaximumArmorHitpointsMod, fltMaximumArmorHitpoints, fltCurrentArmorHitpoints;
	protected float fltEnergyMaintenanceModifier, fltEnergyMaintenance;
	protected float fltMassModifier, fltMass;
	protected int reverseEngineeringLevel;
	
	public boolean equals(ShipComponent a)
	{
		return a.strType.equals(this.strType);
	}
	
	public String getStrType()
	{
		return strType;
	}
	public String getStrComments()
	{
		return strComments;
	}
	public float getFltCurrentHitpoints()
	{
		return fltCurrentHitpoints;
	}
	public float getFltMaximumHitpoints()
	{
		return fltMaximumHitpoints;
	}
	public float getFltMaximumArmorHitpointsMod()
	{
		return fltMaximumArmorHitpointsMod;
	}
	public float getFltMaximumArmorHitpoints()
	{
		return fltMaximumArmorHitpoints;
	}
	public float getFltCurrentArmorHitpoints()
	{
		return fltCurrentArmorHitpoints;
	}
	public float getFltEnergyMaintenanceModifier()
	{
		return fltEnergyMaintenanceModifier;
	}
	public float getFltEnergyMaintenance()
	{
		return fltEnergyMaintenance;
	}
	public float getFltMassModifier()
	{
		return fltMassModifier;
	}
	public float getFltMass()
	{
		return fltMass;
	}
	public int getReverseEngineeringLevel()
	{
		return reverseEngineeringLevel;
	}
}
