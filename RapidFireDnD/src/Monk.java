import java.util.Scanner;

public class Monk extends Character{
	
	private Scanner scan = new Scanner(System.in);
	public Monk() {
		super();
		
	}
	
	public void createChar() {
		super.setCharClass("Monk");
		System.out.print("Enter the name of your " + super.getCharClass() + " character: ");
		super.setName(scan.nextLine());
		
//		System.out.print("Enter the race for your class: ");
//		super.setRace(scan.nextLine());
//		System.out.print("Enter you alignment: ");
//		super.setAlignment(scan.nextLine());
//		System.out.println();
		rollStats();
		strength = dice[1];
		dexterity = dice[5];
		constitution = dice[2];
		intelligence = dice[3];
		wisdom = dice[4];
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
