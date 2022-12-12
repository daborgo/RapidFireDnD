import java.util.Random;
import java.util.Scanner;

public class Range extends Weapon {
	private int spread;
	private int piercing;
	private Random rand = new Random();
	private Scanner scan = new Scanner(System.in);

	public Range() {
		super();
	}
	
	public void createRange() {
		super.setWeaponType("Range");
		// implement weaponSlot based on character weapons
		System.out.println("Enter the name of this " + super.getWeaponType() + " weapon: ");
		super.setName(scan.next());
		System.out.println();
		level = 1;
		exp = 0;
		durability = rand.nextInt(50)+50;
		
		spread = rand.nextInt(5)+1;
		piercing = rand.nextInt(3)+1;
		modDamage = (spread+piercing)/2;
		range = rand.nextInt(6)+4;
		if(range<3) { attackType = "Near"; } else if(range<5) { attackType = "Mid"; } else { attackType = "Far"; }
		attackSpeed = (int)(Math.ceil((level*(0.5*(spread+range)))));
		attackBest = "Undead";
		attackWorst = "Human";
	}
	
	public String toString() {
		return super.toString() + "Spread: " + spread + "\nPiercing: " + piercing + "\n\n";
	}

	public int getSpread() {
		return spread;
	}
	public void setSpread(int spread) {
		this.spread = spread;
	}
	public int getPiercing() {
		return piercing;
	}
	public void setPiercing(int piercing) {
		this.piercing = piercing;
	}
}
