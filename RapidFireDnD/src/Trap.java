import java.util.Random;
import java.util.Scanner;

public class Trap extends Event{
	private int roll;
	private Random rand = new Random();
	private Scanner scan = new Scanner(System.in);
	
	public int[] createTrap() throws InterruptedException {
		int[] ret = new int[2];
		eventType = "Trap";
		System.out.println("You've encountered a trap! Enter to roll the dice to determine your punishment...");
		scan.nextLine();
		switch(rand.nextInt(4)) {
		case 0:
			eventDesc = "Your character's boots suddenly latch on to the ground, stuck in some sort of wet concrete.";
			mod = 0;
			break;
		case 1:
			eventDesc = "Your character realizes they've stepped into a bear trap laying on the ground.";
			mod = 0;
			break;
		case 2:
			eventDesc = "A cage, sprung from above, swoops down to imprison your character.";
			mod = 1;
			break;
		case 3:
			eventDesc = "A magical straitjacket conjured by some higher power appears around your character's body.";
			mod = 2;
			break;
		}
		roll = rand.nextInt(6)+1;
		strength = (int)Math.ceil((roll/2));
		System.out.println(eventDesc);
		Thread.sleep(4000);
		System.out.println("\n\nDamage Taken: " + strength);
		ret[0] = -1;
		ret[1] = strength;
		attackBest = "Barbarian";
		attackWorst = "Druid";
		String s;
		if(strength<1) s = "not very"; else s = "very";
		System.out.println("It is " + s + " effective.\nStrong against " + attackBest + " and weak against " + attackWorst + ".");
		Thread.sleep(4000);
		return ret;
	}
}
