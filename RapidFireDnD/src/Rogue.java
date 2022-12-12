import java.util.Scanner;

public class Rogue extends Character{

private Scanner scan = new Scanner(System.in);
	
	public Rogue() {
		super();
		
	}
	
	public void createChar() {
		super.setCharClass("Rogue");
		System.out.print("Enter the name of your " + super.getCharClass() + " character: ");
		super.setName(scan.nextLine());
//		System.out.print("Enter the race for your class: ");
//		super.setRace(scan.nextLine());
//		System.out.print("Enter you alignment: ");
//		super.setAlignment(scan.nextLine());
//		System.out.println();
		rollStats();
		strength = dice[0];
		dexterity = dice[5];
		constitution = dice[1];
		intelligence = dice[4];
		wisdom = dice[2];
		charisma = dice[3];
//		raceMod(race);
		strengthMod = modifiers(strength);	
		dexterityMod = modifiers(dexterity);
		constitutionMod = modifiers(constitution);
		intelligenceMod = modifiers(intelligence);
		wisdomMod = modifiers(wisdom);
		charismaMod = modifiers(charisma);
		
		level = 1;
		hitDie(charClass);
	}
}
