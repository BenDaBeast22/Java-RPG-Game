import processing.core.PApplet;

//A class that creates objects that are randomly dropped that boosts the players max attack
public class Pencil extends PApplet{
	public int pencilCounter;//The amount of pencil item that you have
	
	/**
	 * Creates a pencil object
	 */
	public Pencil() {
		pencilCounter = 0;
		
	}
	/**
	 * Adds a pencil item to a counter so it can be used
	 */
	public void add() {
		pencilCounter+=1;
	}
	/**
	 * Boosts players max attack 
	 * @param s - player thats attack gets boosted
	 */
	public void use(Sprite s) {
		if(pencilCounter>0) {
			pencilCounter-=1;
			s.getAttack();
			s.attack += 5;	
		}
	
	}
}
