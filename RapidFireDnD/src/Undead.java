import java.util.Random;

public class Undead extends Monster{
	private int decay;
	private Random rand = new Random();
	
	public Undead() {
		super();
	}

	public void create() {
		super.setMonsterRace("Undead");
		if(rand.nextInt(2)==0)
			super.setMonsterType("Warrior");
		else
			super.setMonsterType("Archer");
		level = rand.nextInt(4)+1;
		maxHP = level*(rand.nextInt(1)+1)+1;
		currentHP = maxHP;
		
		if(getMonsterType().equals("Warrior"))
			if(rand.nextInt(2)==0)
				weapon = "Fist";
			else
				weapon = "Pitchfork";
		else
			if(rand.nextInt(2)==0)
				weapon = "Bow";
			else
				weapon = "Crossbow";
		
		decay = rand.nextInt(10)+1;
		attackSpeed = (((int)((rand.nextInt(10)+1)-((decay/2)/2)))/2)+1;
		range = level;
		damage = (level+attackSpeed+(decay/4))-1;
		attackBest = "Cleric";
		attackWorst = "Ranger";
	}
	
	public String toString() {
		return super.toString() + "Decay: " + decay;
	}

	public int getDecay() {
		return decay;
	}
	public void setDecay(int decay) {
		this.decay = decay;
	}
}
