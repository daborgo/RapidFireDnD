import java.util.Scanner;

public class Paladin extends Character{

private Scanner scan = new Scanner(System.in);
	
	public Paladin() {
		super();
		
	}
	
	public void createChar() {
		super.setCharClass("Paladin");
		System.out.print("Enter the name of your " + super.getCharClass() + " character: ");
		super.setName(scan.nextLine());
//		System.out.print("Enter the race for your class: ");
//		super.setRace(scan.nextLine());
//		System.out.print("Enter you alignment: ");
//		super.setAlignment(scan.nextLine());
//		System.out.println();
		rollStats();
		strength = dice[5];
		dexterity = dice[3];
		constitution = dice[2];
		intelligence = dice[1];
		wisdom = dice[0];
		charisma = dice[4];
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
