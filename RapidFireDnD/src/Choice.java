import java.util.Random;
import java.util.Scanner;

public class Choice extends Event {
	private int roll;
	private int choice;
	private Random rand = new Random();
	private Scanner scan = new Scanner(System.in);
	
	public int[] createChoice() throws InterruptedException {
		int[] ret = new int[2];
		eventType = "Choice";
		eventDesc = "You've encountered a choice!";
		switch(rand.nextInt(3)) {
		case 0:
			System.out.println(eventDesc + "\nThree goblets are presented in front of your character. One of them has poison, and the other two are water. Which will you choose?\nEnter a number 1-3: ");
			choice = scan.nextInt();
			if(choice==rand.nextInt(3)+1) {
				System.out.println("Your character takes a cautious sip out of goblet #"+choice+"...and starts to notice something strange. It must have been poison!");
				Thread.sleep(4000);
				roll = rand.nextInt(6)+1;
				strength = (int)Math.ceil((roll/2))+mod;
				System.out.println("Damage Taken: " + strength);
				ret[0] = -1;
				ret[1] = strength;
			} else {
				System.out.println("Your character takes a cautious sip out of goblet #"+choice+"...and heaves a sigh of relief as it turns out to be water. They escape unscathed.");
				Thread.sleep(4000);
				ret[0] = 0;
				ret[1] = 0;
			}	
			break;
		case 1:
			System.out.println(eventDesc + "\nThree boxes appear on a table in front of your character. Which will you choose to put your hand in?\nEnter a number 1-3: ");
			choice = scan.nextInt();
			if(choice==rand.nextInt(3)+1) {
				System.out.println("Your character puts their hand inside box #"+choice+"...and finds treasure!");
				Thread.sleep(4000);
				int gold = rand.nextInt(5)+1;
				System.out.println("Gold Found: " + gold + " pieces");
				ret[0] = 1;
				ret[1] = gold;
			} else {
				System.out.println("Your character puts their hand inside box #"+choice+"...and withdraws it hastily. They've been bitten by something inside!");
				Thread.sleep(4000);
				roll = rand.nextInt(5)+1;
				strength = (int)Math.ceil((roll));
				System.out.println("Damage Taken: " + strength);
				ret[0] = -1;
				ret[1] = strength;
			}
			break;
//		case 2:
//			System.out.println(eventDesc + "\nTwo doors appear in front of your character.\nChoose the door to enter by entering 1 or 2: ");
//			choice = scan.nextInt();
//			if(choice==rand.nextInt(2)+1) {
//				System.out.println("Your character walks through door #" + choice + ".");
//				System.out.print("Your character encounters a monster!");
//				Monster m = null;
//				int temp = rand.nextInt(3);
//				if(temp==0)
//					m = new Human();
//				else if(temp==1)
//					m = new Undead();
//				else if(temp==2)
//					m = new Spirit();
//				m.create();
//				System.out.println(m.toString());
//			} else {
//				System.out.println("Your character walks through door #" + choice + ".");
//				switch(rand.nextInt(3)) {
//				case 0:
//					Trap t = new Trap();
//					t.createTrap();
//					System.out.println(t.toString());
//					break;
//				case 1:
//					Disaster d = new Disaster();
//					d.createDisaster();
//					System.out.println(d.toString());
//					break;
//				case 2:
//					Choice c = new Choice();
//					c.createChoice();
//					break;
//				}
//			}
//			break;
		}
		attackBest = "Rogue";
		attackWorst = "Warlock";
		System.out.println("Strong against " + attackBest + " and weak against " + attackWorst + ".");
		Thread.sleep(4000);
		return ret;
	}
}
