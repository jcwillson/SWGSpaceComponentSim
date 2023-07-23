package modified;
/*
 * This is where the parts are generated, and written into the appropriate output file.
 */
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import datatables.Aggregator;
import datatables.ShipComponent;

public class XSim {
	
	public static boolean runXSim(String type, int x, String path)
	{
		//Creating an object containing all parts stat of specified type
		Aggregator partsList = new Aggregator(type);
		//And pulling said list out of the object
		ArrayList<ShipComponent> parts = partsList.getParts();
		
		//Iterate through each component
		for(int i = 0; i < parts.size(); i++)
		{
			ShipComponent thisComponent = parts.get(i);
			
			//String culling to proper format to find partName for output file path
			String[] cullOne = thisComponent.getStrType().split("/",10);
			String[] cullTwo = cullOne[cullOne.length-1].split("\\.", 2);
			String partName = cullTwo[0];
			
			int RELevel = thisComponent.getReverseEngineeringLevel();
			if(RELevel != 0)
			{
				File output = new File(path + "\\" + type + "\\" + thisComponent.getReverseEngineeringLevel() + "\\" + partName + ".csv");
				try
				{
					//If this is first time this part has been simulated, create the output file, otherwise overwrite
					if(!output.exists())
						output.createNewFile();
					FileWriter outting = new FileWriter(output, false);
					obj_id sim = new obj_id(type,partName);
					
					//Creating header line in CSV
					outting.write(sim.header());
					
					//Simulate x number of this part
					for (int j = 0; j < x; j++)
					{
						//Reinitialize the obj_id to keep it clean
						sim = new obj_id(type,partName);
						//Generate the stats
						space_crafting.initializeSpaceShipComponent(sim,  partsList);
						//Write the stats
						outting.write(sim.toString());
					}
					outting.close();
				}
				catch (Exception e)
				{
					System.out.println(e);
					return false;
				}
			}
		}
		return true;
	}
}
