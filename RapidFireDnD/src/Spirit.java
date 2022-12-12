import java.util.Random;

public class Spirit extends Monster{
	private int transcendence;
	private Random rand = new Random();
	
	public Spirit() {
		super();
	}

	public void create() {
		super.setMonsterRace("Spirit");
		if(rand.nextInt(2)==0)
			super.setMonsterType("Warrior");
		else
			super.setMonsterType("Summoner");
		level = rand.nextInt(3)+1;
		maxHP = level*(rand.nextInt(1)+1)+1;
		currentHP = maxHP;
		
		if(getMonsterType().equals("Warrior"))
			if(rand.nextInt(2)==0)
				weapon = "Spear";
			else
				weapon = "Lance";
		else
			if(rand.nextInt(2)==0)
				weapon = "Wand";
			else
				weapon = "Totem";
		
		transcendence = rand.nextInt(10)+1;
		attackSpeed = ((int)(Math.ceil((transcendence/2))/2)*(rand.nextInt(1)+1))+1;
		range = level;
		damage = (level+attackSpeed+(transcendence/4))-1;
		attackBest = "Paladin";
		attackWorst = "Bard";
	}
	
	public String toString() {
		return super.toString() + "Transcendence: " + transcendence;
	}

	public int getTranscendence() {
		return transcendence;
	}
	public void setTranscendence(int transcendence) {
		this.transcendence = transcendence;
	}
}
