import java.util.Random;

public class Human extends Monster{
	private int age;
	private Random rand = new Random();
	
	public Human() {
		super();
	}

	public void create() {
		super.setMonsterRace("Human");
		if(rand.nextInt(2)==0)
			super.setMonsterType("Warrior");
		else
			super.setMonsterType("Mage");
		level = rand.nextInt(5)+1;
		maxHP = level*(rand.nextInt(1)+1)+2;
		currentHP = maxHP;
		if(getMonsterType().equals("Warrior"))
			if(rand.nextInt(2)==0)
				weapon = "Sword";
			else
				weapon = "Mace";
		else
			if(rand.nextInt(2)==0)
				weapon = "Book";
			else
				weapon = "Staff";
		
		age = rand.nextInt(100)+1;
		attackSpeed = ((int)(Math.ceil((age/20))/2)*(rand.nextInt(1)+1))+1;
		range = level/2+1;
		damage = (level+attackSpeed+(age/25))-1;
		attackBest = "Monk";
		attackWorst = "Sorcerer";
	}
	
	public String toString() {
		return super.toString() + "Age: " + age;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
