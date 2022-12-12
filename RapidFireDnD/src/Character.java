import java.util.Arrays;
import java.util.Random;

public class Character {
	protected String charClass;
	protected int level;
	protected int exp;
	private String name;
	protected int maxhp;
	protected int currentHP;
	
	
	private String hitDice;
	protected int goldPieces;
	private String savingThrowProficiencies;
	private String armorAndWeaponProficiencies;
	protected Weapon weapon;
	private int armorClass;
	
	protected int strength;
	protected int dexterity;
	protected int constitution;
	protected int intelligence;
	protected int wisdom;
	protected int charisma;

	protected int dexterityMod;
	protected int constitutionMod;
	protected int intelligenceMod;
	protected int wisdomMod;
	protected int charismaMod;
	protected int strengthMod;
	
	private String primaryAbility;
	protected Random rand = new Random();
	
	protected int dice[] = new int[6];
	
	protected void hitDie(String race) {
		switch(race) {
		case "Barbarian":
			hitDice = "d12";
			primaryAbility = "Strength";
			savingThrowProficiencies = "Strength & Constitution";
			armorAndWeaponProficiencies = "Light and medium armor, shields,\n"
					+ "simple and martial weapons";
			goldPieces = 0 ;
			armorClass = 10 +constitutionMod + dexterityMod;
			maxhp = currentHP = 22 + constitutionMod;
			break;
		case "Bard":
			hitDice = "d8";
			primaryAbility = "Charisma";
			savingThrowProficiencies = "Dexterity & Charisma";
			armorAndWeaponProficiencies = "Light armor, simple weapons, hand\n"
					+ "crossbows, longswords, rapiers,\n"
					+ "shortswords";
			goldPieces = 0 ;
			armorClass = 10 +constitutionMod + wisdomMod;
			maxhp = currentHP = 18 + constitutionMod;
			break;
		case "Cleric":
			hitDice = "d8";
			primaryAbility = "Wisdom";
			savingThrowProficiencies = "Wisdom & Charisma";
			armorAndWeaponProficiencies = "Light and medium armor, shields,\n"
					+ "simple weapons";
			goldPieces = 0;
			armorClass = 10 +constitutionMod + dexterityMod;
			maxhp = currentHP = 18 + constitutionMod;
			break;
		case "Druid":
			hitDice = "d8";
			primaryAbility = "Wisdom";
			savingThrowProficiencies = "Intelligence & Wisdom";
			armorAndWeaponProficiencies = "Light and medium armor (nonmetal),\n"
					+ "shields (nonmetal), clubs, daggers,\n"
					+ "darts, javelins, maces, quarterstaffs,\n"
					+ "scimitars, sickles, slings, spears";
			goldPieces = 0;
			maxhp = currentHP = 18 + constitutionMod;
			armorClass = 10 +constitutionMod + dexterityMod;
			break;
		case "Fighter":
			hitDice = "d10";
			primaryAbility = "Strength or Dexterity";
			savingThrowProficiencies = "Strength & Constitution";
			armorAndWeaponProficiencies = "All armor, shields, simple and martial\n"
					+ "weapons";
			goldPieces = 0;
			maxhp = currentHP = 20 + constitutionMod;
			armorClass = 10 +constitutionMod + dexterityMod;
			break;
		case "Monk":
			hitDice = "d8";
			primaryAbility = "Dexterity & Wisdom";
			savingThrowProficiencies = "Strength & Dexterity";
			armorAndWeaponProficiencies = "Simple weapons, shortswords";
			goldPieces = 0;
			maxhp = currentHP = 18 + constitutionMod;
			armorClass = 10 +constitutionMod + dexterityMod;
			break;
		case "Paladin":
			hitDice = "d10";
			primaryAbility = "Strength & Charisma";
			savingThrowProficiencies = "Wisdom & Charisma";
			armorAndWeaponProficiencies = "All armor, shields, simple and martial\n"
					+ "weapons";
			goldPieces = 0;
			maxhp = currentHP = 20 + constitutionMod;
			armorClass = 10 +constitutionMod + dexterityMod;
			break;
		case "Ranger":
			hitDice = "d10";
			primaryAbility = "Dexterity & Wisdom";
			savingThrowProficiencies = "Strength & Dexterity";
			armorAndWeaponProficiencies = "Light and medium armor, shields,\n"
					+ "simple and martial weapons";
			goldPieces = 0;
			maxhp = currentHP = 20 + constitutionMod;
			armorClass = 10 +constitutionMod + dexterityMod;
			break;
		case "Rogue":
			hitDice = "d8";
			primaryAbility = "Dexterity";
			savingThrowProficiencies = "Dexterity & Intelligence";
			armorAndWeaponProficiencies = "Light armor, simple weapons, hand\n"
					+ "crossbows, longswords, rapiers,\n"
					+ "shortswords";
			goldPieces = 0;
			maxhp = currentHP = 18 + constitutionMod;
			armorClass = 10 +constitutionMod + dexterityMod;
			break;
		case "Sorcerer":
			hitDice = "d6";
			primaryAbility = "Charisma";
			savingThrowProficiencies = "Constitution & Charisma";
			armorAndWeaponProficiencies = "Daggers, darts, slings, quarterstaffs,\n"
					+ "light crossbows";
			goldPieces = 0;
			maxhp = currentHP = 16 + constitutionMod;
			armorClass = 10 +constitutionMod + dexterityMod;
			break;
		case "Warlock":
			hitDice = "d8";
			primaryAbility = "Charisma";
			savingThrowProficiencies = "Wisdom & Charisma";
			armorAndWeaponProficiencies = "Light armor, simple weapons";
			goldPieces = 0;
			maxhp = currentHP = 18 + constitutionMod;
			armorClass = 10 +constitutionMod + dexterityMod;
			break;
		case "Wizard":
			hitDice = "d6";
			primaryAbility = "Intelligence";
			savingThrowProficiencies = "Intelligence & Wisdom";
			armorAndWeaponProficiencies = "Daggers, darts, slings, quarterstaffs,\n"
					+ "light crossbows";
			goldPieces = 0;
			maxhp = currentHP = 16 + constitutionMod;
			armorClass = 10 +constitutionMod + dexterityMod;
			break;
		
		}
	}
	protected void rollStats() {
		
		int roll[] = new int[6];
		
		for(int m = 0; m < dice.length; m++) {
			
			for(int i = 0; i < roll.length; i++) {
				roll[i] = rand.nextInt(6)+1;
			}
			sortArray(roll);
			dice[m] = roll[3] + roll[4] + roll[5];
		}
		sortArray(dice);
		
	}
	
	protected int[] sortArray(int[] roll) {
		Arrays.sort(roll);
		return roll;
	}
	
	
	protected int modifiers(int value) {
		
		int mod = 0;
		
		switch(value) {
		case 1:
			mod = -5;
			break;
		case 2:
		case 3:
			mod = -4;
			break;
		case 4:
		case 5:
			mod = -3;
			break;
		case 6:
		case 7:
			mod = -2;
			break;
		case 8:
		case 9:
			mod = -1;
			break;
		case 10:
		case 11:
			mod = 0;
			break;
		case 12:
		case 13:
			mod = 1;
			break;
		case 14:
		case 15:
			mod = 2;
			break;
		case 16:
		case 17:
			mod = 3;
			break;
		case 18:
		case 19:
			mod = 4;
			break;
		case 20:
		case 21:
			mod = 5;
			break;
		case 22:
		case 23:
			mod = 6;
			break;
		case 24:
		case 25:
			mod = 7;
			break;
		case 26:
		case 27:
			mod = 8;
			break;
		case 28:
		case 29:
			mod = 9;
			break;
		case 30:
			mod = 10;
			break;
		}
		
		return mod;
	}
	
	protected void raceMod(String race) {
		if(race.equalsIgnoreCase("Mountain Dwarf") || race.equalsIgnoreCase("Dragonborn") || race.equalsIgnoreCase("Half-orc") || race.equalsIgnoreCase("Human")) {
			if(race.equalsIgnoreCase("Human"))
				strength +=1;
			else
				strength +=2;
		}
		if(race.equalsIgnoreCase("Elf") || race.equalsIgnoreCase("Halfling") || race.equalsIgnoreCase("Forest Gnome") || race.equalsIgnoreCase("Human")) {
			if(race.equalsIgnoreCase("Forest Gnome") || race.equalsIgnoreCase("Human"))
				dexterity += 1;
			else
				dexterity += 2;
		}
		if(race.equalsIgnoreCase("Dwarf") || race.equalsIgnoreCase("Stout Halfling") || race.equalsIgnoreCase("Rock Gnome") || race.equalsIgnoreCase("Half-orc") || race.equalsIgnoreCase("Human")) {
			if(race.equalsIgnoreCase("Dwarf"))
				constitution += 2;
			else
				constitution += 1;
		}
		if(race.equalsIgnoreCase("High Elf") || race.equalsIgnoreCase("Gnome") || race.equalsIgnoreCase("Tiefling") || race.equalsIgnoreCase("Human")) {
			if(race.equalsIgnoreCase("Gnome"))
				intelligence += 2;
			else
				intelligence += 1;
		}
		if(race.equalsIgnoreCase("Hill dwarf") || race.equalsIgnoreCase("Wood elf") ||  race.equalsIgnoreCase("Human")) {
			
				wisdom += 1;
		}
		if(race.equalsIgnoreCase("Half-elf") || race.equalsIgnoreCase("Drow") || race.equalsIgnoreCase("Lightfoot halfling") || race.equalsIgnoreCase("Tiefling") || race.equalsIgnoreCase("Dragonborn") || race.equalsIgnoreCase("Human")) {
			if(race.equalsIgnoreCase("Tiefling") || race.equalsIgnoreCase("Half-elf"))
				constitution += 2;
			else
				constitution += 1;
		}
			
	}
	
	public void createChar() {
		
	}
	
	public String toString() {
		String basicInfo = "Name: " + name + "\nClass: " + charClass + "\tLevel: " + level
				+ "\nExperience Points: " + exp + "\tCurrent HP: " + currentHP
				+"\nHit Dice: " + hitDice + "\t Primary Ability: " + primaryAbility + "\nSaving Throw Proficiencies: "+ savingThrowProficiencies
				+"\nGold: " + goldPieces
				+"\nAC: " + armorClass;
		
		
		String stats = "\n\nStrength:" + strength +"(" + strengthMod +")" 
				+ "\nDexterity:" + dexterity +"(" + dexterityMod +")"
				+ "\nConstitution:" + constitution +"(" + constitutionMod +")"
				+ "\nIntelligence:" + intelligence +"(" + intelligenceMod +")"
				+ "\nWisdom:" + wisdom +"(" + wisdomMod +")"
				+ "\nCharisma:" + charisma +"(" + charismaMod +")"
				+ "\nArmor And Weapon Proficiencies: " + armorAndWeaponProficiencies +"\n";
		
		return (basicInfo + stats);
	}
	
	public String getCharClass() {
		return charClass;
	}

	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getDamage() {
		return (level+((strength+dexterity+constitution+intelligence+wisdom+charisma+strengthMod+dexterityMod+constitutionMod+intelligenceMod+wisdomMod+charismaMod)/20))/2;
	}
	
}
