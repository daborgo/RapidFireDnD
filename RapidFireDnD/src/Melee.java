import java.util.Random;
import java.util.Scanner;

public class Melee extends Weapon {
	private int finesse;
	private int critChance;
	private Random rand = new Random();
	private Scanner scan = new Scanner(System.in);

	public Melee() {
		super();
	}
	
	public void createMelee() {
		super.setWeaponType("Melee");
		// implement weaponSlot based on character weapons
		System.out.println("Enter the name of this " + super.getWeaponType() + " weapon: ");
		super.setName(scan.nextLine());
		System.out.println();
		level = 1;
		exp = 0;
		durability = rand.nextInt(50)+50;
		finesse = rand.nextInt(5)+1;
		critChance = rand.nextInt(3)+1;
		modDamage = (finesse+critChance)/2;
		range = rand.nextInt(3)+1;
		if(range<3) { attackType = "Near"; } else if(range<5) { attackType = "Mid"; } else { attackType = "Far"; }
		attackSpeed = (int)(Math.ceil((level*(0.25*(finesse+range)))));
		attackBest = "Human";
		attackWorst = "Spirit";
	}
	
	public String toString() {
		return super.toString() + "Finesse: " + finesse + "\nCrit Chance: " + critChance + "\n\n";
	}
	
	public int getFinesse() {
		return finesse;
	}
	public void setFinesse(int finesse) {
		this.finesse = finesse;
	}
	public int getCritChance() {
		return critChance;
	}
	public void setCritChance(int critChance) {
		this.critChance = critChance;
	}
}
