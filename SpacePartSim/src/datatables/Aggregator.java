package datatables;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Aggregator {

	protected ArrayList<ShipComponent> parts;
	
	public Aggregator(String type)
	{
		String line = "";
		parts = new ArrayList<ShipComponent>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jcwga\\git\\SpacePartSimRepo\\SpacePartSim\\src\\datatables\\" + type + ".tab"));
			//Skip header and typing line
			br.readLine();
			br.readLine();
			//Switch casing for type
			switch(type) {
				case "armor":{
					while((line = br.readLine()) != null)
						parts.add(new Armor(line));
					break;
				}
				case "booster":{
					while((line = br.readLine()) != null)
						parts.add(new Booster(line));
					break;
				}
				case "capacitor":{
					while((line = br.readLine()) != null)
						parts.add(new Capacitor(line));
					break;
				}
				case "droid_interface":{
					while((line = br.readLine()) != null)
						parts.add(new DroidInterface(line));
					break;
				}
				case "engine":{
					while((line = br.readLine()) != null)
						parts.add(new Engine(line));
					break;
				}
				case "reactor":{
					while((line = br.readLine()) != null)
						parts.add(new Reactor(line));
					break;
				}
				case "shield":{
					while((line = br.readLine()) != null)
						parts.add(new Shield(line));
					break;
				}
				case "weapon":{
					while((line = br.readLine()) != null)
						parts.add(new Weapon(line));
					break;
				}
			}
			br.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(@SuppressWarnings("hiding") IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ShipComponent> getParts()
	{
		return parts;
	}
	
	public int find(String name)
	{
		for(int i=0; i<parts.size(); i++)
		{
			if(parts.get(i).strType.equals(name))
				return i;
		}
		return -1;
	}
}
