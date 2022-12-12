import java.util.Random;
import java.util.Scanner;

public class Disaster extends Event{
	private int roll;
	private Random rand = new Random();
	private Scanner scan = new Scanner(System.in);
	
	public int[] createDisaster() throws InterruptedException {
		int[] ret = new int[2];
		eventType = "Disaster";
		System.out.println("You've encountered a disaster! Enter to roll the dice to determine your punishment...");
		scan.nextLine();
		switch(rand.nextInt(4)) {
		case 0:
			eventDesc = "The room suddenly fills with water, as your character struggles to stay afloat.";
			mod = 0;
			break;
		case 1:
			eventDesc = "Vines and roots suddenly spring from the ground and encircle your character's legs.";
			mod = 0;
			break;
		case 2:
			eventDesc = "A snowstorm, seemingly by magic, suddenly manifests in the room, enveloping your character.";
			mod = 1;
			break;
		case 3:
			eventDesc = "The ground suddenly turns into quicksand, and your character sinks down to their neck.";
			mod = 2;
			break;
		}
		roll = rand.nextInt(6)+1;
		strength = (int)Math.ceil((roll/2))+mod;
		System.out.println(eventDesc);
		Thread.sleep(4000);
		System.out.println("\n\nDamage Taken: " + strength);
		ret[0] = -1;
		ret[1] = strength;
		attackBest = "Fighter";
		attackWorst = "Wizard";
		String s;
		if(strength==1||strength==2) s = "not very"; else s = "very";
		System.out.println("It is " + s + " effective.\nStrong against " + attackBest + " and weak against " + attackWorst + ".");
		Thread.sleep(4000);
		return ret;
	}
}
