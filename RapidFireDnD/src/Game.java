import java.util.*;

public class Game {
	Character c;
	String gamemode;
	boolean playing;
	boolean game;
	int heals;
	int[] tally;
	Object[][] map = null;
	String[][] mapCheck = null;
	String[][] mapHidden = null;
	ArrayList<int[]> location = new ArrayList<int[]>();
	ArrayList<Weapon> inv = new ArrayList<Weapon>();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();

	public Game(int i) {
		map = new Object[i][i];
		mapCheck = new String[i][i];
		mapHidden = new String[i][i];
		location.add(new int[]{0,0});
		for(int j = 0; j<map.length; j++) {
			for(int k = 0; k<map[j].length; k++) {
				mapHidden[j][k] = "?";
				int temp = rand.nextInt(10);
				if(j==0&k==0) {
					map[j][k] = null;
					mapCheck[j][k] = "X";
				} else if(temp<5) {
					Monster m = null;
					switch(rand.nextInt(3)) {
					case 0:
						m = new Human();
						break;
					case 1:
						m = new Undead();
						break;
					case 2:
						m = new Spirit();
						break;
					}
					map[j][k] = m;
					mapCheck[j][k] = "M";
				} else if(temp<7) {
					Event e = null;
					switch(rand.nextInt(3)) {
					case 0:
						e = new Trap();
						break;
					case 1:
						e = new Disaster();
						break;
					case 2:
						e = new Choice();
						break;
					}
					map[j][k] = e;
					mapCheck[j][k] = "E";
				} else if(temp<9) {
					Weapon w = null;
					switch(rand.nextInt(3)) {
					case 0:
						w = new Melee();
						break;
					case 1:
						w = new Magic();
						break;
					case 2:
						w = new Range();
						break;
					}
					map[j][k] = w;
					mapCheck[j][k] = "W";
				} else {
					map[j][k] = null;
					mapCheck[j][k] = "X";
				}
			}
		}
		heals = (int)Math.ceil(1.75*(i-3));
		if(heals<1)
			heals = 1;
		tally = new int[3];
		playing = true;
	}
	
	public void setup() throws InterruptedException {
		System.out.println("\nChoose a character from the list below:"
				+ "\n1) Barbarian\tBad at escaping traps."
				+ "\n2) Bard   \tStrong against spirit enemies."
				+ "\n3) Cleric\tWeak against undead enemies."
				+ "\n4) Druid\tGood at escaping traps."
				+ "\n5) Fighter\tBad in disasters."
				+ "\n6) Monk   \tWeak against human enemies."
				+ "\n7) Paladin\tWeak against spirit enemies."
				+ "\n8) Ranger\tStrong against undead enemies."
				+ "\n9) Rogue\tBad at choices."
				+ "\n10) Sorcerer\tStrong against human enemies."
				+ "\n11) Warlock\tGood at choices."
				+ "\n12) Wizard\tGood in disasters.\n");
		int temp = scan.nextInt();
		System.out.println();
		switch(temp) {
		case 1:
			c = new Barbarian();
			break;
		case 2:
			c = new Bard();
			break;
		case 3:
			c = new Cleric();
			break;
		case 4:
			c = new Druid();
			break;
		case 5:
			c = new Fighter();
			break;
		case 6:
			c = new Monk();
			break;
		case 7:
			c = new Paladin();
			break;
		case 8:
			c = new Ranger();
			break;
		case 9:
			c = new Rogue();
			break;
		case 10:
			c = new Sorcerer();
			break;
		case 11:
			c = new Warlock();
			break;
		case 12:
			c = new Wizard();
			break;
		}
		c.createChar();
		System.out.println("\n\n\n" + c.toString());
		Thread.sleep(5000);
		System.out.println("\n\n\nCreating your starter weapon...\n");
		Melee starting = new Melee();
		starting.createMelee();
		c.weapon = starting;
		System.out.println("Weapon created!");
		Thread.sleep(2000);
		System.out.println("\n\n\n\n\n\n\n\nThe story begins...\n\n\n");
		Thread.sleep(3000);
		System.out.println("Darkness. A flash of light. The darkness transitions fully to the light.");
		Thread.sleep(5000);
		System.out.println("\n" + c.getName() + " opens their eyes, immediately sensing something is off.");
		Thread.sleep(3000);
		System.out.println("They groggily raise their head, looking around in a daze.");
		Thread.sleep(3000);
		System.out.println("As they struggle to get up, they try to piece the puzzle together.");
		Thread.sleep(3000);
		System.out.println("They come to the conclusion they are stranded in some sort of underground prison.");
		Thread.sleep(5000);
		System.out.println("Suddenly, a voice pierces the air.");
		Thread.sleep(2000);
		System.out.println("\n\"" + c.getName() + "...\"");
		Thread.sleep(5000);
		System.out.println("\nThe voice gets slightly louder.");
		Thread.sleep(3000);
		System.out.println("\n\"" + c.getName() + "...you are this dungeon's newest challenger. You must explore the whole dungeon and take on its challenges to succeed.\"");
		Thread.sleep(6000);
		System.out.println("\n" + c.getName() + " is immediately skeptical, yet understands they are powerless to escape in their current situation.");
		Thread.sleep(4000);
		System.out.println("They muster up their courage, and embark upon their quest...\n\n\n");
		Thread.sleep(4000);
		System.out.println("(You start the game with " + heals + " heals)");
		Thread.sleep(3000);
		System.out.println("\n(Game started! CLEAR ALL ROOMS TO WIN!)");
		Thread.sleep(4000);
	}
	
	public void play() throws InterruptedException {
		while(playing) {
			System.out.println(mainView());
			System.out.print("Command: ");
			String comm = scan.next();
			if(comm.toUpperCase().equals("C")) {
				System.out.println("\n-----COMMANDS-----\n{U = Move Up // D = Move Down // L = Move Left // R = Move Right}\n{S = Character Stats // W = Weapon Stats // I = Inventory // H = Heal // Q = Quit}\n");
				Thread.sleep(5000);
			}
			else if(comm.toUpperCase().equals("U")) { 
				if(location.get(location.size()-1)[0]>0) {
					location.add(new int[]{location.get(location.size()-1)[0]-1,location.get(location.size()-1)[1]});
					room();
				} else {
					System.out.println("Invalid: Boundary Reached");
					Thread.sleep(1500);
				}
			}
			else if(comm.toUpperCase().equals("D")) { 
				if(location.get(location.size()-1)[0]<map.length-1) {
					location.add(new int[]{location.get(location.size()-1)[0]+1,location.get(location.size()-1)[1]});
					room();
				} else {
					System.out.println("Invalid: Boundary Reached");
					Thread.sleep(1500);
				}
			}
			else if(comm.toUpperCase().equals("L")) { 
				if(location.get(location.size()-1)[1]>0) {
					location.add(new int[]{location.get(location.size()-1)[0],location.get(location.size()-1)[1]-1});
					room();
					
				} else {
					System.out.println("Invalid: Boundary Reached");
					Thread.sleep(1500);
				}
			}
			else if(comm.toUpperCase().equals("R")) { 
				if(location.get(location.size()-1)[1]<map[location.get(location.size()-1)[0]].length-1) {
					location.add(new int[]{location.get(location.size()-1)[0],location.get(location.size()-1)[1]+1});
					room();
				} else {
					System.out.println("Invalid: Boundary Reached");
					Thread.sleep(1500);
				}
			}
			else if(comm.toUpperCase().equals("S")) {
				System.out.println("\n\n-----CHARACTER STATS-----\n" + c.toString());
				Thread.sleep(6000);
			}
			else if(comm.toUpperCase().equals("W")) {
				System.out.println("\n\n-----ACTIVE WEAPON STATS-----" + c.weapon.toString());
				Thread.sleep(6000);
			}
			else if(comm.toUpperCase().equals("I")) {
				boolean done = false;
				while(!done) {
					boolean found = false;
					System.out.println("\n\n-----INVENTORY-----");
					if(inv.size()==0) {
						System.out.println("<empty>");
					} else {
						for(int i = 0; i<inv.size(); i++) {
								System.out.println(inv.get(i).getName() + " (" + inv.get(i).getWeaponType() + ")");
						}
					}
					System.out.println("\n(Enter a number to get stats for that weapon (0 for equipped weapon, up to " + inv.size() + " for inventory weapons) \n\"E\" to exit)");
					String wait = scan.next();
					if(wait.toUpperCase().equals("E")) {
						done = true;
						break;
					}
					if(Integer.parseInt(wait)==0) {
						System.out.println("\n" + c.weapon.toString());
						found = true;
					}
					for(int i = 0; i<inv.size(); i++) {
						if(Integer.parseInt(wait)-1==i) {
							System.out.println("\n" + inv.get(i).toString());
							found = true;
							break;
						}
					}
					if(!found) {
						if(wait.toString().toUpperCase().equals("E")) {
							done = true;
						} else {
							System.out.println("Invalid: Number doesn't exist or Unknown Command");
						}
					} else if(Integer.parseInt(wait)==0){
						
					} else {
						System.out.println("Would you like to swap this weapon with your equipped weapon? (Y or N)");
						String choice = scan.next();
						if(choice.toUpperCase().equals("Y")) {
							Weapon w = c.weapon;
							inv.add(w);
							c.weapon = inv.get(Integer.parseInt(wait)-1);
							inv.remove(Integer.parseInt(wait)-1);
						} else if(choice.toUpperCase().equals("N")) {
						} else {
							System.out.println("Invalid: Unknown Command\n");
						}
					}
				}
			}
			else if(comm.toUpperCase().equals("H")) {
				System.out.println("\nYou currently have " + heals + " heals.");
				Thread.sleep(2000);
				if(c.currentHP==c.maxhp) {
					System.out.println("You're already full health!");
					Thread.sleep(2000);
				} else if(heals<=0) {
					System.out.println("None remaining! You're on your own...");
					Thread.sleep(2000);
				} else {
					heals--;
					System.out.println("Your character was healed to full HP! (" + c.currentHP + " -> " + c.maxhp + ")");
					c.currentHP = c.maxhp;
					Thread.sleep(2000);
					System.out.println(heals + " heals now remaining...");
					Thread.sleep(2000);
				}
			}
			else if(comm.toUpperCase().equals("Q")) {
				System.out.println("\nYou exit the dungeon.");
				Thread.sleep(1500);
				System.out.println("\n---Final Stats---");
				System.out.println("Monsters Defeated: " + tally[0]);
				System.out.println("Events Cleared: " + tally[1]);
				System.out.println("Weapons Found: " + tally[2]);
				System.out.println("Gold Count: " + c.goldPieces);
				Thread.sleep(6000);
				playing = false;
				game = false;
			}
			else {
				System.out.println("Invalid: Unknown Command");
				Thread.sleep(1000);
			}
			
			int count = 0;
			for(int i = 0; i<map.length; i++) {
				for(int j = 0; j<map[i].length; j++) {
					if(mapHidden[i][j].equals("?"))
						count++;
				}
			}
			if(count<=1) {
				game = true;
				playing = false;
			}
		}
		if(game) {
			System.out.println("\n*** CONGRATULATIONS! ***");
			Thread.sleep(2000);
			System.out.println("You have cleared the dungeon!");
			Thread.sleep(3000);
			System.out.println("\n---Final Stats---");
			System.out.println("Monsters Defeated: " + tally[0]);
			System.out.println("Events Cleared: " + tally[1]);
			System.out.println("Weapons Found: " + tally[2]);
			System.out.println("Gold Count: " + c.goldPieces);
		} else {
			System.out.println("\nThanks for playing!");
		}
	}
	
	public String mainView() {
		String s = "\n\n\n";
		for(int i = 0; i<map.length*6+1; i++) { s += "-"; }
		s += "\n";
		for(int i = 0; i<map.length; i++) {
			for(int j = 0; j<map[i].length; j++) {
				s += "|";
				for(int k = 0; k<5; k++) {
					s += " ";
				}
			}
			s += "|\n";
			for(int j = 0; j<map[i].length; j++) {
				if(map[i][j]==null)
					s += "|  " + mapCheck[i][j].toString() + "  ";
				else
					s += "|  " + mapHidden[i][j].toString() + "  ";
			}
			s += "|\n";
			for(int j = 0; j<map[i].length; j++) {
				s += "|";
				for(int k = 0; k<5; k++) {
					s += " ";
				}
			}
			s += "|\n";
			for(int k = 0; k<map.length*6+1; k++) { s += "-"; }
			s += "\n";
		}
		s += "? = Uncleared Room, X = Empty Room, M/E/W = Cleared Room (hidden until entered and cleared)\n";
		s += "(M = Monster, E = Event, W = Weapon)\n\nYou are here: Row " + (location.get(location.size()-1)[0]+1) + ", Column " +  (location.get(location.size()-1)[1]+1);
		s += "\nType \"C\" for commands...\n";
		return s;
	}
	
	public void room() throws InterruptedException {
		System.out.println("\n\n");
		Object o = map[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]];
		
		if(o!=null) {
			if(c.currentHP<(c.maxhp/4)) {
				System.out.println("You hobble into the room, already injured from your previous hard-fought battles...");
				Thread.sleep(3000);
			} else {
				switch(rand.nextInt(3)) {
				case 0:
					System.out.println("You stride confidently into the room, unafraid of the dangers ahead...");
					Thread.sleep(3000);
					break;
				case 1:
					System.out.println("You walk tentatively into the room, unsure of what to expect...");
					Thread.sleep(3000);
					break;
				case 2:
					System.out.println("You tiptoe into the room, fearful of what might lie in store...");
					Thread.sleep(3000);
					break;
				}
			}
		}
		
		if(o instanceof Monster) {
			Monster m = null;
			System.out.println("\nYou encountered a monster!");
			Thread.sleep(2000);
			int temp = rand.nextInt(3);
			if(temp==0)
				m = new Human();
			else if(temp==1)
				m = new Undead();
			else if(temp==2)
				m = new Spirit();
			m.create();
			System.out.println(m.toString());
			Thread.sleep(4000);
			System.out.println("\nYou face each other, staring intimidatingly, but neither of you wants to back down...\n");
			Thread.sleep(3000);
			System.out.println("(The battle begins!)");
			Thread.sleep(2000);
			boolean b = battle(m);
			if(b) {
				o = null;
				map[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = null;
				mapHidden[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = "!";
				tally[0]++;
			}
			if(!b && c==null) {
				game = false;
				playing = false;
			}
		} else if(o instanceof Event) {
			System.out.println("\nYou encountered an event!\n");
			Thread.sleep(2000);
			int temp = rand.nextInt(3);
			if(temp==0) {
				Choice ch = new Choice();
				int[] result = ch.createChoice();
				if(result[0]==-1)
					c.currentHP -= result[1];
				else if(result[0]==1)
					c.goldPieces += result[1];
				o = null;
				map[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = null;
				mapHidden[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = "!";
				tally[1]++;
			}
			else if(temp==1) {
				Disaster di = new Disaster();
				int[] result = di.createDisaster();
				if(result[0]==-1)
					c.currentHP -= result[1];
				else if(result[0]==1)
					c.goldPieces += result[1];
				o = null;
				map[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = null;
				mapHidden[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = "!";
				tally[1]++;
			}
			else if(temp==2) {
				Trap tr = new Trap();
				int[] result = tr.createTrap();
				if(result[0]==-1)
					c.currentHP -= result[1];
				else if(result[0]==1)
					c.goldPieces += result[1];
				o = null;
				map[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = null;
				mapHidden[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = "!";
				tally[1]++;
			}
		} else if(o instanceof Weapon) {
			System.out.println("\nYou found a weapon!");
			Thread.sleep(1500);
			System.out.println("You thank your lucky stars as you walk over to pick up your weapon.\n");
			
			switch(rand.nextInt(3)) {
			case 0:
				Melee m = new Melee();
				m.createMelee();
				System.out.println(m.toString());
				System.out.println("\nWould you like to keep this weapon as a (1) active or (2) stored weapon?");
				switch(scan.nextInt()) {
				case 1:
					Weapon w = c.weapon;
					inv.add(w);
					c.weapon = m;
					break;
				case 2:
					inv.add(m);
				}
				break;
			case 1:
				Magic ma = new Magic();
				ma.createMagic();
				System.out.println(ma.toString());
				System.out.println("\nWould you like to keep this weapon as a (1) active or (2) stored weapon?");
				switch(scan.nextInt()) {
				case 1:
					Weapon w = c.weapon;
					inv.add(w);
					c.weapon = ma;
					break;
				case 2:
					inv.add(ma);
				}
				break;
			case 2:
				Range r = new Range();
				r.createRange();
				System.out.println(r.toString());
				System.out.println("\nWould you like to keep this weapon as a (1) active or (2) stored weapon?");
				switch(scan.nextInt()) {
				case 1:
					Weapon w = c.weapon;
					inv.add(w);
					c.weapon = r;
					System.out.println("\nWeapon equipped!\n");
					Thread.sleep(1500);
					break;
				case 2:
					inv.add(r);
					System.out.println("\nWeapon stored!\n");
					Thread.sleep(1500);
					break;
				}
				break;
			}
			o = null;
			map[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = null;
			mapHidden[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = "!";
			tally[2]++;
		} else {
			System.out.println("You entered an empty/cleared room! There's nothing there.");
			mapHidden[location.get(location.size()-1)[0]][location.get(location.size()-1)[1]] = "!";
			Thread.sleep(2000);
			return;
		}
	}
	
	public boolean battle(Monster m) throws InterruptedException {
		boolean fight = true;
		boolean win = true;
		boolean dead = false;
		
		int modifier = 0;	
		if(m.getAttackBest().equals(c.getCharClass()))
			modifier--;
		if(m.getAttackWorst().equals(c.getCharClass()))
			modifier += 2;
		if(c.weapon.getAttackBest().equals(m.getMonsterRace()))
			modifier ++;
		if(c.weapon.getAttackWorst().equals(m.getMonsterRace()))
			modifier--;
		
		int turns = 0;
		int distance = 5;
		while(fight) {
			turns++;
			System.out.println("\n\n\n\n-----BATTLE-----");
			System.out.print("> Battle Modifier: ");
			if(modifier>0)
				System.out.println("+" + modifier + " <");
			else
				System.out.println(modifier + " <");
			System.out.println(c.getName() + " (" + c.weapon.getName() + "): HP (" + c.currentHP + ") Base Damage (" + c.getDamage() + ") Range (" + c.weapon.getRange() + ")");
			System.out.println(m.getMonsterRace() + " " + m.getMonsterType() + ": HP (" + m.getCurrentHP() + ") Base Damage (" + m.getDamage() + ") Range (" + m.getRange() + ")");
			System.out.println("Turn " + turns + " -- Distance " + distance);
			System.out.println("(F = Forward, B = Backward, A = Attack, R = Run Away)");
			System.out.print("\nCommand: ");
			String in = scan.next();
			if(in.toUpperCase().equals("F")) {
				if(distance<=1) {
					System.out.println("\n* Careful!!! Too close! (You lost your turn)");
				} else {
					distance--;
					System.out.println("\n* You take a step forward. (Distance now " + distance + " steps)");
				}
			} else if(in.toUpperCase().equals("B")) {
				if(distance>=10) {
					System.out.println("\n* Careful!!! You reached max distance! (You lost your turn)");
				} else {
					distance++;
					System.out.println("\n* You take a step backward. (Distance now " + distance + " steps)");
				}
			} else if(in.toUpperCase().equals("A")) {
				if(c.weapon.weaponType.equals("Melee"))
					System.out.print("\n* You swing your " + c.weapon.name + " at the monster! It does ");
				if(c.weapon.weaponType.equals("Magic"))
					System.out.print("\n* You cast your " + c.weapon.name + " at the monster! It does ");
				if(c.weapon.weaponType.equals("Range"))
					System.out.print("\n* You fire your " + c.weapon.name + " at the monster! It does ");
				int d = c.getDamage() + c.weapon.getDamage()/4 + modifier + rand.nextInt(2)+1;
				if(c.weapon.range>=distance) {
					System.out.println(d + " damage!");
					m.setCurrentHP(m.getCurrentHP()-d);
				} else if(c.weapon.range>=distance-c.weapon.range) {
					d -= c.weapon.range-(distance-c.weapon.range)+1;
					if(d<=0)
						d = 1;
					System.out.println(d + " damage! (slightly out of range)");
					m.setCurrentHP(m.getCurrentHP()-d);
				} else {
					System.out.println("0 damage. (out of range)");
				}
				Thread.sleep(1000);
				c.weapon.setExp(c.weapon.getExp()+d);
				if(c.weapon.getExp()>=(10*c.weapon.getLevel())) {
					c.weapon.setLevel(c.weapon.getLevel()+1);
					c.weapon.setExp(0);
					System.out.println("(" + c.weapon.getName() + " level up! Now level " + c.weapon.getLevel() + ")");
				}
				c.weapon.setDurability(c.weapon.getDurability()-d*2);
				if(c.weapon.getDurability()<=20 && c.weapon.getDurability()>0) {
					System.out.println("(" + c.weapon.getName() + " is fragile...)");
				} else if(c.weapon.getDurability()<=0) {
					System.out.print("(" + c.weapon.getName() + " broke!");
					if(inv.size()==0) {
						System.out.println(" Weapon temporarily renewed, none remaining in inventory)");
					} else {
						c.weapon = inv.get(0);
						inv.remove(0);
						System.out.println(" Replaced with " + c.weapon.getName() + ")");
					}
				}
				c.exp = c.exp+d;
				if(c.exp>=(16*c.level)) {
					c.level = c.level+1;
					c.exp = 0;
					c.strength++;
					c.dexterity++;
					c.constitution++;
					c.intelligence++;
					c.wisdom++;
					c.charisma++;
					System.out.println("(You leveled up! Now level " + c.level + ")");
				}
				Thread.sleep(2000);
				if(m.getCurrentHP()<=0) {
					System.out.println("\n*** You defeated the " + m.getMonsterRace().toLowerCase() + " " + m.getMonsterType().toLowerCase() + "! ***");
					int goldEarned = m.getLevel() + m.getDamage();
					c.goldPieces += goldEarned;
					System.out.println("Gold Earned: " + goldEarned + " pieces (You now have " + c.goldPieces + " gold pieces)");
					fight = false;
					dead = true;
					Thread.sleep(5000);
				}
					
			} else if(in.toUpperCase().equals("R")) {
				System.out.println("\nYou ran away!\nGold Earned: 0\n");
				Thread.sleep(3000);
				fight = false;
				win = false;
				break;
			}
			if(!dead) {
				Thread.sleep(3000);
				if(m.getRange()<distance-m.getRange()+1) {
					distance--;
					System.out.println("* The " + m.getMonsterRace().toLowerCase() + " " + m.getMonsterType().toLowerCase() + " takes a step forward. (Distance now " + distance + " steps)");
				} else {
					System.out.print("* The " + m.getMonsterRace().toLowerCase() + " " + m.getMonsterType().toLowerCase() + " uses their " + m.getWeapon() + ". It does ");
					int md = c.getDamage() + c.weapon.getDamage()/4 + modifier + rand.nextInt(2)+1;
					if(m.getRange()>=distance) {
						System.out.println(md + " damage!");
						c.currentHP = c.currentHP-md;
					} else if(m.getRange()>=distance-m.getRange()) {
						md -= m.getRange()-(distance-m.getRange())+1;
						if(md<=0)
							md = 1;
						System.out.println(md + " damage! (slightly out of range)");
						c.currentHP = c.currentHP-md;
					} else {
						System.out.println("0 damage. (out of range)");
					}
				}
				Thread.sleep(2000);
				if(c.currentHP<=0) {
					System.out.println("*** You died... ***");
					Thread.sleep(2000);
					System.out.println("\nThe power of the dungeon was too much for " + c.getName() + " to handle, and they succumbed to an " + m.getMonsterRace().toLowerCase() + " " + m.getMonsterType().toLowerCase() + " in the end...");
					win = false;
					fight = false;
					c = null;
					Thread.sleep(5000);
					System.out.println("\n---Final Stats---");
					System.out.println("Monsters Defeated: " + tally[0]);
					System.out.println("Events Cleared: " + tally[1]);
					System.out.println("Weapons Found: " + tally[2]);
				}
			}	
		}
		return win;
	}
}