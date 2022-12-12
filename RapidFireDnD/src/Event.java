import java.util.Random;

public class Event {

	protected String eventType;
	protected String eventDesc;
	protected int eventDuration;
	protected int strength;
	protected int mod;
	protected String attackBest;
	protected String attackWorst;
	protected Random rand = new Random();
	
	public int[] create() {
		return new int[2];
	}
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public int getEventDuration() {
		return eventDuration;
	}
	public void setEventDuration(int eventDuration) {
		this.eventDuration = eventDuration;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
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
	
	