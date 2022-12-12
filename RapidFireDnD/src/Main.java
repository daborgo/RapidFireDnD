import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Dungeons and Dragons!\nThis is a fantasy RPG where your character travels through an enemy-infested dungeon.\n");
		boolean bool = true;
		while(bool) {
			System.out.println("Type \"S\" to start a new game!\nType \"H\" to get help on how to play the game!\nType \"Q\" to quit!\n");
			String input = scan.next();
			if(input.toUpperCase().equals("S")) {
				System.out.println("\nStarting new game...Welcome to the dungeon...\n\nSelect a map size (?x? square):\n");
				int size = scan.nextInt();
				Game g = null;
				if(size<=1) {
					System.out.println("Invalid: Size too small\n");
					Thread.sleep(1500);
				} else {
					g = new Game(size);
					g.setup();
					g.play();
					bool = false;
				}
			} else if(input.toUpperCase().equals("H")) {
				System.out.println("\n-----HELP-----");
				System.out.println("This version of Dungeons and Dragons (created by Diego Borgo) is a simple, rapid-fire time trial...\n...in which you guide your character through an unknown dungeon of a select size to overcome all obstacles.\nYou win by clearing all of the rooms in your chosen dungeon.");
				System.out.println("\nMenu Commands:\n - U = Move Up\n - D = Move Down\n - L = Move Left\n - R = Move Right\n - S = Character Stats\n - W = Weapon Stats\n - I = Inventory\n - H = Heal\n - Q = Quit\n\n\n");
				Thread.sleep(9000);
			} else if(input.toUpperCase().equals("Q")) {
				System.out.println("\nThanks for playing!");
				System.exit(0);
			} else {
				System.out.println("\nInvalid: Unknown Command\n");
			}
		}
		scan.close();
	}
}