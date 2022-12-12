import java.util.Scanner;

public class Wizard extends Character{

private Scanner scan = new Scanner(System.in);
	
	public Wizard() {
		super();
		
	}
	
	public void createChar() {
		super.setCharClass("Wizard");
		System.out.print("Enter the name of your " + super.getCharClass() + " character: ");
		super.setName(scan.nextLine());
		
//		System.out.print("Enter the race for your class: ");
//		super.setRace(scan.nextLine());
//		System.out.print("Enter you alignment: ");
//		super.setAlignment(scan.nextLine());
//		System.out.println();
		rollStats();
		strength = dice[0];
		dexterity = dice[3];
		constitution = dice[4];
		intelligence = dice[5];
		wisdom = dice[1];
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
