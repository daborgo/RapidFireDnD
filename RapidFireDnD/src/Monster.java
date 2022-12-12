import java.util.Random;

public class Monster {
	// Types: Human Warrior, Human Mage, Undead Warrior, Undead Archer, Spirit Warrior, Spirit Summoner
	protected String monsterRace;
	protected String monsterType;
	protected int level;
	protected int maxHP;
	protected int currentHP;
	protected String weapon;
	protected int attackSpeed;
	protected int range;
	protected int damage;
	protected String attackBest;
	protected String attackWorst;
	protected Random rand = new Random();
	
	public void create() {
		
	}
	
	public String toString() {
		return "\nMonster: " + monsterRace + " " + monsterType + "\tLevel: " + level 
				+ "\nMax HP: " + maxHP + "\tCurrent HP: " + currentHP
				+ "\nWeapon: " + weapon + "\tAttack Speed: " + attackSpeed + "\tRange: " + range
				+ "\nPowerful Against: " + attackBest + "\tWeak Against: " + attackWorst + "\n";
	}

	
	public String getMonsterRace() {
		return monsterRace;
	}


	public void setMonsterRace(String monsterRace) {
		this.monsterRace = monsterRace;
	}


	public String getMonsterType() {
		return monsterType;
	}


	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}


	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public int getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public String getAttackBest() {
		return attackBest;
	}
	public void setAttackBest(String attackBest) {
		this.attackBest = attackBest;
	}
	public String getAttackWorst() {
		return attackWorst;
	}
	public void setAttackWorst(String attackWorst) {
		this.attackWorst = attackWorst;
	}
	public int getDamage() {
		if(damage<=0)
			return 1;
		else
			return damage;
	}
}
