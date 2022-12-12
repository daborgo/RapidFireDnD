import java.util.Scanner;

public class Barbarian extends Character{
	private Scanner scan = new Scanner(System.in);
	
	public Barbarian() {
		super();
		
	}
	
	public void createChar() {
		super.setCharClass("Barbarian");
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
		constitution = dice[4];
		intelligence = dice[2];
		wisdom = dice[1];
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
