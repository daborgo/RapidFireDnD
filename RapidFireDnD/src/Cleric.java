import java.util.Scanner;

public class Cleric extends Character{
	private Scanner scan = new Scanner(System.in);


	public Cleric() {
		super();
		
	}
	
	public void createChar() {
		super.setCharClass("Cleric");
		System.out.print("Enter the name of your " + super.getCharClass() + " character: ");
		super.setName(scan.nextLine());
		
//		System.out.print("Enter the race for your class: ");
//		super.setRace(scan.nextLine());
//		System.out.print("Enter you alignment: ");
//		super.setAlignment(scan.nextLine());
//		System.out.println();
		rollStats();
		strength = dice[4];
		dexterity = dice[2];
		constitution = dice[3];
		intelligence = dice[1];
		wisdom = dice[5];
		charisma = dice[0];
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
