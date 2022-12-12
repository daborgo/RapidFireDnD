import java.util.Random;

public class Weapon {
	
	protected String weaponType;
	protected String weaponSlot;
	protected String name;
	protected int level;
	protected int exp;
	protected double durability;
	protected String attackType; 
	protected int attackSpeed;
	protected int range;
	protected String attackBest;
	protected String attackWorst;
	protected int modDamage;
	protected Random rand = new Random();
	
	
	public String toString() {
		return "\nWeapon Name: " + name + "\nWeapon Type: " + weaponType 
				+ "\nLevel: " + level + "\tExperience Points: " + exp + "\tDurability: " + durability
				
				+ "\n\nAttack Type: " + attackType + "\nAttack Speed: " + attackSpeed
				+ "\t\tRange: " + range + "\nPowerful Against: " + attackBest + "\nWeak Against: " + attackWorst + "\n";
	}
	
	public int getDamage() {
		return (level+attackSpeed+modDamage)/4;
	}
	
	
	public String getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeaponSlot() {
		return weaponSlot;
	}
	public void setWeaponSlot(String weaponSlot) {
		this.weaponSlot = weaponSlot;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public double getDurability() {
		return durability;
	}
	public void setDurability(double durability) {
		this.durability = durability;
	}
	public int getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public String getAttackType() {
		return attackType;
	}
	public void setAttackType(String attackType) {
		this.attackType = attackType;
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
}
