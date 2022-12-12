import java.util.Random;
import java.util.Scanner;

public class Magic extends Weapon {
	private int manaCost;
	private int lingering;
	private Random rand = new Random();
	private Scanner scan = new Scanner(System.in);

	public Magic() {
		super();
	}
	
	public void createMagic() {
		super.setWeaponType("Magic");
		// implement weaponSlot based on character weapons
		System.out.println("Enter the name of this " + super.getWeaponType() + " weapon: ");
		super.setName(scan.nextLine());
		System.out.println();
		level = 1;
		exp = 0;
		durability = rand.nextInt(50)+50;
		manaCost = rand.nextInt(10)+1;
		lingering = rand.nextInt(3)+1;
		modDamage = (manaCost+lingering)/3;
		range = rand.nextInt(4)+2;
		if(range<3) { attackType = "Near"; } else if(range<5) { attackType = "Mid"; } else { attackType = "Far"; }
		attackSpeed = (int)(Math.ceil(level*((0.125*manaCost)+(0.25*range))));
		attackBest = "Spirit";
		attackWorst = "Undead";		
	}
	
	public String toString() {
		return super.toString() + "Mana Cost: " + manaCost + "\nLingering: " + lingering + "\n\n";
	}

	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	public int getLingering() {
		return lingering;
	}
	public void setLingering(int lingering) {
		this.lingering = lingering;
	}
}
