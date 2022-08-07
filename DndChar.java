package dndModifiers;
import java.util.Scanner;
import java.util.HashMap;


/*
 * things to do:
 * proficiency for things like arcana and sleight of hand, which would be essentially this but more
 */
public class DndChar {
	private String Name, Race;
	private boolean Advantage = false, Disadvantage = false;
	private HashMap<String, DndStats> statBlock = new HashMap<String, DndStats>();
	private HashMap<String, Integer> advDisadv = new HashMap<String, Integer>();
	
	public DndChar (String CharName, int[] stats, String CharRace) {
		statBlock.put("str", new DndStats(stats[0]));
	    statBlock.put("dex", new DndStats(stats[1]));
	    statBlock.put("con", new DndStats(stats[2]));
	    statBlock.put("int", new DndStats(stats[3]));
	    statBlock.put("wis", new DndStats(stats[4]));
	    statBlock.put("cha", new DndStats(stats[5]));
		Name = CharName;
		Race = CharRace;
		advDisadv.put("adv", 1);
		advDisadv.put("Disadv", 2);
		advDisadv.put("none", 0);
	}
	
	// this way of putting everything in a different method is gonna get me yelled at by my comp sci teacher fun
	public void runrolls() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What would you like to roll? (Str/Dex/Con/Int/Wis/Cha/Dmg)");
		String input = scan.nextLine().toLowerCase();
		// if they type in damage here, it rolls damage, otherwise it rolls for whatever else they want,.
			if (input.equals("dmg") == true){
				System.out.println("What is the die you will be rolling? Put only the number, not 'd8', just 8.");
				int dieNum = scan.nextInt();
				System.out.println("How many of this die will you be rolling?");
				int dieAmt = scan.nextInt();
				System.out.println("What will be the damage increases to these rolls?");
				int dmgIncrease = scan.nextInt();
				System.out.println("Your damage is :" + DndRoll.rollDamage(dieNum, dieAmt, dmgIncrease));
			}
			else{
				System.out.println("Does this roll have advantage or disadvantage? Adv/Disadv/none");
				String advcheck = scan.nextLine();
				int adv = advDisadv.get(advcheck);
					if (adv == 1) {
						Advantage = true;
					}
					else if (adv == 2) {
						Disadvantage = true;
					}
				System.out.println("Do you have any racial modifiers for this roll? If not, input 0, if so, input the number as an integer.");
				int raceMod = scan.nextInt();
				System.out.println("Do you have any class modifiers for this roll? If not, input 0, if so, input the number as an integer.");
				int classMod = scan.nextInt();
				DndRoll roll = new DndRoll (Advantage, Disadvantage, statBlock.get(input), raceMod, classMod);
				System.out.println(roll.rollSaveCheck() + " is the roll with" + roll);
			}
		
	}
}
