package modified;
/*
 * The majority of this code was taken from SWG-SOURCE and rewritten to use different method calls
 */
import datatables.*;
import unmodified.*;

public class space_crafting
{
    public space_crafting()
    {
    }

    /*
     * This method is 100% direct copy of SWG-SOURCE
     */
    public static double randBell(double avg, double var)
    {
        var = var / 2;
        double r, v1, v2;
        do
        {
            v1 = 2.0 * random.rand() - 1.0;
            v2 = 2.0 * random.rand() - 1.0;
            r = v1 * v1 + v2 * v2;
        } while (r >= 1.0 || r == 0.0);
        double fac = Math.sqrt(-2.0 * StrictMath.log(r) / r);
        double value = (avg + (v1 * fac) * (avg * var));
        if (value < 0)
        {
            return 0;
        }
        else 
        {
            return value;
        }
    }
    
    /*
     * This method is 100% direct copy of SWG-SOURCE
     */
    public static float getBellValue(float fltValue, float fltModifier)
    {
        return (float)(randBell(fltValue, fltModifier));
    }
    
    /*
     * This method is 100% direct copy of SWG-SOURCE
     */
    public static float getModifiedValue(float fltValue, float fltModifier)
    {
        fltValue = fltValue + random.rand(-1 * fltModifier, fltModifier);
        return fltValue;
    }
    
    /*
     * This method is 100% direct copy of SWG-SOURCE
     */
    public static float getRawModifiedValue(float fltModifier)
    {
        return random.rand(-1 * fltModifier, fltModifier);
    }

    /*
     * This method follow the framework of SWG-SOURCE, but uses the custom obj_id calls to store values.
     * Superfluous stat values are commented out, but left intact for reference.
     * 
     * The method itself rolls and sets the stats for all shared stats among all parts.
     */
    public static obj_id setupStandardStatistics(obj_id objComponent, ShipComponent dctParams)// throws InterruptedException
    {
    	//Retrieval of base values and modifiers, followed by random generation
        float fltEnergyMaintenanceModifier = dctParams.getFltEnergyMaintenanceModifier();
        float fltEnergyMaintenance = dctParams.getFltEnergyMaintenance();
        fltEnergyMaintenance = getBellValue(fltEnergyMaintenance, fltEnergyMaintenanceModifier);

        float fltMassModifier = dctParams.getFltMassModifier();
        float fltMass = dctParams.getFltMass();
        fltMass = getBellValue(fltMass, fltMassModifier);

        float fltEfficiency = dctParams.getFltEfficiency();

        float fltArmor = dctParams.getFltMaximumArmorHitpoints();
        float fltArmorMod = dctParams.getFltMaximumArmorHitpointsMod();
        fltArmor = getBellValue(fltArmor, fltArmorMod);

        //Setting of calculated stat values
        
        //setComponentCurrentArmorHitpoints(objComponent, fltArmor);
        objComponent.setComponentMaximumArmorHitpoints(objComponent, fltArmor);

        //setComponentMaximumConduitHitpoints(objComponent, fltArmor);
        //setComponentCurrentConduitHitpoints(objComponent, fltArmor);

        //setComponentCurrentHitpoints(objComponent, fltArmor);
        objComponent.setComponentMaximumHitpoints(objComponent, fltArmor);

        objComponent.setComponentMass(objComponent, fltMass);

        objComponent.setComponentEnergyMaintenance(objComponent, fltEnergyMaintenance);
        objComponent.setComponentEnergyEfficiency(objComponent, fltEfficiency);
        //setComponentGeneralEfficiency(objComponent, fltEfficiency);

        return objComponent;
    }
   
    /*
     * This method follow the framework of SWG-SOURCE, but uses the custom obj_id calls to store values.
     * Superfluous stat values are commented out, but left intact for reference.
     * 
     * This method first calls the standard statistics setup, then switches to setup specific stats this part has.
     */
    public static obj_id initializeSpaceShipComponent(obj_id objComponent, Aggregator parts)
    {
        String strComponentType = objComponent.getShipComponentType();
        
        //Checking to make sure the objComponent is an actual Component
        if (!strComponentType.equals(""))
        {
        	ShipComponent dctParams;
        	//Special case handling due to capacitor and shield having slightly different path name then componentType
        	if(strComponentType.equals("capacitor"))
        		dctParams = parts.getParts().get(parts.find("object/tangible/ship/components/weapon_capacitor/" + objComponent.getTemplateName() + ".iff"));
        	else if(strComponentType.equals("shield"))
        		dctParams = parts.getParts().get(parts.find("object/tangible/ship/components/shield_generator/" + objComponent.getTemplateName() + ".iff"));
        	else
        		dctParams = parts.getParts().get(parts.find("object/tangible/ship/components/" + strComponentType + "/" + objComponent.getTemplateName() + ".iff"));
        	
        	//Shared stats call
            objComponent = setupStandardStatistics(objComponent, dctParams);
            
            //All armor stats are covered by the shared stats call
            if (!strComponentType.equals("armor")) {
            	//Switch selection to get base values and modifiers, then random generation and setting by module type
                switch (strComponentType) {
                    case "booster": {
                    	Booster boosterParams = (Booster) dctParams;
                        float fltCurrentEnergy = boosterParams.getFltCurrentEnergy();
                        float fltMaximumEnergyModifier = boosterParams.getFltMaximumEnergyModifier();
                        float fltMaximumEnergy = boosterParams.getFltMaximumEnergy();
                        float fltRoll = random.rand(-1 * fltMaximumEnergyModifier, fltMaximumEnergyModifier);
                        fltMaximumEnergy = fltMaximumEnergy + fltRoll;
                        fltCurrentEnergy = fltCurrentEnergy + fltRoll;
                        objComponent.setBoosterMaximumEnergy(objComponent, fltMaximumEnergy);
                        //setBoosterCurrentEnergy(objComponent, fltCurrentEnergy);
                        float fltRechargeRateModifier = boosterParams.getFltRechargeRateModifier();
                        float fltRechargeRate = boosterParams.getFltRechargeRate();
                        fltRechargeRate = getBellValue(fltRechargeRate, fltRechargeRateModifier);
                        objComponent.setBoosterEnergyRechargeRate(objComponent, fltRechargeRate);
                        float fltConsumptionRateModifier = boosterParams.getFltConsumptionRateModifier();
                        float fltConsumptionRate = boosterParams.getFltConsumptionRate();
                        fltConsumptionRate = getBellValue(fltConsumptionRate, fltConsumptionRateModifier);
                        objComponent.setBoosterEnergyConsumptionRate(objComponent, fltConsumptionRate);
                        float fltAccelerationModifier = boosterParams.getFltAccelerationModifier();
                        float fltAcceleration = boosterParams.getFltAcceleration();
                        fltAcceleration = getBellValue(fltAcceleration, fltAccelerationModifier);
                        objComponent.setBoosterAcceleration(objComponent, fltAcceleration);
                        float fltMaxSpeedModifier = boosterParams.getFltMaxSpeedModifier();
                        float fltMaxSpeed = boosterParams.getFltMaxSpeed();
                        fltMaxSpeed = getBellValue(fltMaxSpeed, fltMaxSpeedModifier);
                        objComponent.setBoosterMaximumSpeed(objComponent, fltMaxSpeed);
                        break;
                    }
                    /*
                    case "cargo_hold":
                        int intCargoHoldCapacity = dctParams.getInt("intCargoHoldCapacity");
                        setCargoHoldMaxCapacity(objComponent, intCargoHoldCapacity);
                        break;
                        */
                    case "droid_interface":
                    	DroidInterface droidParams = (DroidInterface) dctParams;
                        float fltCommandSpeedModifier = droidParams.getFltCommandSpeedModifier();
                        float fltCommandSpeed = droidParams.getFltCommandSpeed();
                        fltCommandSpeed = getBellValue(fltCommandSpeed, fltCommandSpeedModifier);
                        objComponent.setDroidInterfaceCommandSpeed(objComponent, fltCommandSpeed);
                        break;
                    case "engine": {
                    	Engine engineParams = (Engine) dctParams;
                        float fltMaxSpeedModifier = engineParams.getFltMaxSpeedModifier();
                        float fltMaxSpeed = engineParams.getFltMaxSpeed();
                        fltMaxSpeed = getBellValue(fltMaxSpeed, fltMaxSpeedModifier);
                        objComponent.setEngineMaximumSpeed(objComponent, fltMaxSpeed);
                        float fltMaxPitchModifier = engineParams.getFltMaxPitchModifier();
                        float fltMaxPitch = engineParams.getFltMaxPitch();
                        fltMaxPitch = getBellValue(fltMaxPitch, fltMaxPitchModifier);
                        objComponent.setEngineMaximumPitch(objComponent, fltMaxPitch);
                        float fltMaxRollModifier = engineParams.getFltMaxRollModifier();
                        float fltMaxRoll = engineParams.getFltMaxRoll();
                        fltMaxRoll = getBellValue(fltMaxRoll, fltMaxRollModifier);
                        objComponent.setEngineMaximumRoll(objComponent, fltMaxRoll);
                        float fltMaxYawModifier = engineParams.getFltMaxYawModifier();
                        float fltMaxYaw = engineParams.getFltMaxYaw();
                        fltMaxYaw = getBellValue(fltMaxYaw, fltMaxYawModifier);
                        objComponent.setEngineMaximumYaw(objComponent, fltMaxYaw);
                        break;
                    }
                    case "reactor":
                    	Reactor reactorParams = (Reactor) dctParams;
                        float fltEnergyGenerationModifier = reactorParams.getFltEnergyGenerationModifier();
                        float fltEnergyGeneration = reactorParams.getFltEnergyGeneration();
                        fltEnergyGeneration = getBellValue(fltEnergyGeneration, fltEnergyGenerationModifier);
                        objComponent.setReactorEnergyGeneration(objComponent, fltEnergyGeneration);
                        break;
                    case "shield":
                    	Shield shieldParams = (Shield) dctParams;
                        float fltShieldHitpointsMaximumFrontModifier = shieldParams.getFltShieldHitpointsMaximumFrontModifier();
                        float fltShieldHitpointsMaximumFront = shieldParams.getFltShieldHitpointsMaximumFront();
                        fltShieldHitpointsMaximumFront = getBellValue(fltShieldHitpointsMaximumFront, fltShieldHitpointsMaximumFrontModifier);
                        float fltShieldHitpointsMaximumBackModifier = shieldParams.getFltShieldHitpointsMaximumBackModifier();
                        float fltShieldHitpointsMaximumBack = shieldParams.getFltShieldHitpointsMaximumFront();
                        fltShieldHitpointsMaximumBack = getBellValue(fltShieldHitpointsMaximumBack, fltShieldHitpointsMaximumBackModifier);
                        //setShieldGeneratorCurrentFrontHitpoints(objComponent, 0.0f);
                        //setShieldGeneratorCurrentBackHitpoints(objComponent, 0.0f);
                        objComponent.setShieldGeneratorMaximumFrontHitpoints(objComponent, fltShieldHitpointsMaximumFront);
                        objComponent.setShieldGeneratorMaximumBackHitpoints(objComponent, fltShieldHitpointsMaximumBack);
                        float fltShieldRechargeRateModifier = shieldParams.getFltShieldRechargeRateModifier();
                        float fltShieldRechargeRate = shieldParams.getFltShieldRechargeRate();
                        fltShieldRechargeRate = getBellValue(fltShieldRechargeRate, fltShieldRechargeRateModifier);
                        objComponent.setShieldGeneratorRechargeRate(objComponent, fltShieldRechargeRate);
                        break;
                    case "weapon":
                    	Weapon weaponParams = (Weapon) dctParams;
                        float fltMinDamageModifier = weaponParams.getFltMinDamageModifier();
                        float fltMinDamage = weaponParams.getFltMinDamage();
                        fltMinDamage = getBellValue(fltMinDamage, fltMinDamageModifier);
                        objComponent.setWeaponMinimumDamage(objComponent, fltMinDamage);
                        float fltMaxDamageModifier = weaponParams.getFltMaxDamageModifier();
                        float fltMaxDamage = weaponParams.getFltMaxDamage();
                        fltMaxDamage = getBellValue(fltMaxDamage, fltMaxDamageModifier);
                        objComponent.setWeaponMaximumDamage(objComponent, fltMaxDamage);
                        float fltShieldEffectivenessModifier = weaponParams.getFltShieldEffectivenessModifier();
                        float fltShieldEffectiveness = weaponParams.getFltShieldEffectiveness();
                        fltShieldEffectiveness = getBellValue(fltShieldEffectiveness, fltShieldEffectivenessModifier);
                        objComponent.setWeaponShieldEffectiveness(objComponent, fltShieldEffectiveness);
                        float fltArmorEffectivenessModifier = weaponParams.getFltArmorEffectivenessModifier();
                        float fltArmorEffectiveness = weaponParams.getFltArmorEffectiveness();
                        fltArmorEffectiveness = getBellValue(fltArmorEffectiveness, fltArmorEffectivenessModifier);
                        objComponent.setWeaponArmorEffectiveness(objComponent, fltArmorEffectiveness);
                        float fltEnergyPerShotModifier = weaponParams.getFltEnergyPerShotModifier();
                        float fltEnergyPerShot = weaponParams.getFltEnergyPerShot();
                        fltEnergyPerShot = getBellValue(fltEnergyPerShot, fltEnergyPerShotModifier);
                        objComponent.setWeaponEnergyPerShot(objComponent, fltEnergyPerShot);
                        float fltRefireRateModifier = weaponParams.getFltRefireRateModifier();
                        float fltRefireRate = weaponParams.getFltRefireRate();
                        fltRefireRate = getBellValue(fltRefireRate, fltRefireRateModifier);
                        objComponent.setWeaponRefireRate(objComponent, fltRefireRate);
                        break;
                    case "capacitor": {
                    	Capacitor capParams = (Capacitor) dctParams;
                        //float fltCurrentEnergy = capParams.getFltCurrentEnergy();
                        float fltMaxEnergyModifier = capParams.getFltMaxEnergyModifier();
                        float fltMaxEnergy = capParams.getFltMaxEnergy();
                        fltMaxEnergy = getBellValue(fltMaxEnergy, fltMaxEnergyModifier);
                        objComponent.setWeaponCapacitorMaximumEnergy(objComponent, fltMaxEnergy);
                        //setWeaponCapacitorCurrentEnergy(objComponent, fltMaxEnergy);
                        float fltRechargeRateModifier = capParams.getFltRechargeRateModifier();
                        float fltRechargeRate = capParams.getFltRechargeRate();
                        fltRechargeRate = getBellValue(fltRechargeRate, fltRechargeRateModifier);
                        objComponent.setWeaponCapacitorRechargeRate(objComponent, fltRechargeRate);
                        break;
                    }
                }
            }
            return objComponent;
        }
        else 
        {
            return objComponent;
        }
    }
}