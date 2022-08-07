package dndModifiers;

public class DndRoll {
	private boolean advantageRoll, disadvantageRoll;
	private DndStats rollMod;
	private int charMod;
	
	// dice time woooo
	public DndRoll() {
	}
	public DndRoll (boolean Advantage, boolean Disadvantage, DndStats statRoll, int raceMod, int classMod) {
		rollMod = statRoll;
		advantageRoll = Advantage;
		disadvantageRoll = Disadvantage;
		// I could probably put it down to just character modifiers, but I would like to have both for new players so they dont get more confused
		charMod = raceMod + classMod;
	}
	
	private int rollResult1, rollResult2;
		
	public int rollSaveCheck() {
		// rolling with two dice and taking the higher one
		if (advantageRoll) {
			rollResult1 = (int)(Math.random()* 20);
			rollResult2 = (int)(Math.random()* 20);
			if (rollResult1 > rollResult2) {
				return (rollResult1 + rollMod.proficiencyRoll()+ charMod);
			}
			else {
				return (rollResult2 + rollMod.proficiencyRoll()+ charMod);
			}
		}
		// rolling with two dice and taking the lower one
		else if (disadvantageRoll) {
			rollResult1 = (int)(Math.random()* 20);
			rollResult2 = (int)(Math.random()* 20);
			if (rollResult1 < rollResult2) {
				return (rollResult1 + rollMod.proficiencyRoll() + charMod);
			}
			else {
				return (rollResult2 + rollMod.proficiencyRoll()+ charMod);
			}
		}
		// rolling with one dice
		else {
		rollResult1 = (int)(Math.random()* 20) + rollMod.proficiencyRoll() + charMod;
		return rollResult1;
		}
	}
	
	// rolling one flat die
	public int rollFlat() {
		rollResult1 = (int)(Math.random()* 20);
		return rollResult1;
	}
	
	private static int damage;
	// rolling damage! dnumber is the number on the die, like a d4, addeddmg is what is said next to spells, like d6+8 and any weapon bonuses, and damount is amount of die being rolled
	public static int rollDamage(int dnumber, int damount, int addedDmg) {
		for (int i = 1; i <= damount; i++) {
			damage = (int)(Math.random()* dnumber) + addedDmg;
		}
		return damage;
	}
	
	public String toString () {
		return rollMod.proficiencyRoll() + charMod + " modifier, with " + advantageRoll + " set to advantage and " + disadvantageRoll + " set to disadvantage";
	}
}
