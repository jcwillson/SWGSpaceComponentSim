package modified;
/*
 * Main method that prompts users for information and makes decisions on what type of simulations is run.
 * Currently only handles bulk simulation of all parts.
 * TODO: Single type sim, single cert, single type and cert, single item
 */
import java.io.File;
import java.util.Scanner;

public class RuntimeChoices {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String path;
		int rolls = 0;
		String[] fileStruct = {"armor","booster","capacitor","droid_interface","engine","reactor","shield","weapon"};
		int[] fileSubStruct = {1,2,3,4,5,6,7,8,9,10};
		Boolean pathInit = false;
		Boolean rollsInit = false;
		System.out.println("Welcome to SWG Space Component Simulator.");
		//Loop to get output file(s) destination
		do {
			System.out.println("Please enter the file path you would like the data output at:");
			path = input.nextLine();
			File structure = new File(path);
			//Creates a generic folder structure to sort bulk simulated files
			try {
				if(structure.exists())
				{
					for(int i=0; i<fileStruct.length; i++)
					{
						File struct = new File(path + "\\" + fileStruct[i]);
						if(!struct.exists())
							struct.mkdir();
						for(int j=0; j<fileSubStruct.length; j++)
						{
							File subStruct = new File(path + "\\" + fileStruct[i] + "\\" + fileSubStruct[j]);
							if(!subStruct.exists())
								subStruct.mkdir();
						}
					}
					pathInit = true;
				}
				else
					System.out.println("Invalid file path, the destination folder must already exist.");
			}
			catch(Exception e)
			{
				System.out.println("Invalid file path.");
			}
		} while (!pathInit);
		
		//Loop to get valid numeric input for number of simulated rolls
		do {
			System.out.println("Please enter the number of simulated rolls for each part:");
			if(input.hasNextInt())
			{
				rolls = input.nextInt();
				if(rolls > 0)
					rollsInit = true;
				else
					System.out.println("Please enter a valid number greater than 0.");
			}
			else
			{
				input.nextLine();
				System.out.println("Please enter a valid integer.");
			}
		} while(!rollsInit);
		
		//Bulk generation of all the parts
		System.out.println("Generating " + 129*rolls*3 + " stat rolls for armor...");
		XSim.runXSim("armor", rolls, path);
		System.out.println("Generating " + 130*rolls*8 + " stat rolls for boosters...");
		XSim.runXSim("booster", rolls, path);
		System.out.println("Generating " + 130*rolls*5 + " stat rolls for capacitors...");
		XSim.runXSim("capacitor", rolls, path);
		System.out.println("Generating " + 112*rolls*4 + " stat rolls for droid interfaces...");
		XSim.runXSim("droid_interface", rolls, path);
		System.out.println("Generating " + 125*rolls*7 + " stat rolls for engines...");
		XSim.runXSim("engine", rolls, path);
		System.out.println("Generating " + 106*rolls*4 + " stat rolls for reactors...");
		XSim.runXSim("reactor", rolls, path);
		System.out.println("Generating " + 124*rolls*6 + " stat rolls for shields...");
		XSim.runXSim("shield", rolls, path);
		System.out.println("Generating " + 120*rolls*9 + " stat rolls for weapons...");
		XSim.runXSim("weapon", rolls, path);
		System.out.println("Data output to: " + path);
		input.close();
	}

}
