import processing.core.PApplet;

//The apple class creates an able object with a random drop that recovers your players health
public class Apple extends PApplet{
	private boolean useApple;
	private boolean check;
	private int heal;
	private int hp;
	public int appleCounter = 0;
	/**
	 * Creates an apple object
	 */
	public Apple() {
		heal = 150;
	}
	/**
	 * Adds an apple to a counter every time its used 
	 */
	public void add() {
		appleCounter += 1;
	}
	/**
	 * Recovers 150 health for the player if you have an apple to use 
	 * @param s - The player that gains health
	 */
	public void use(Sprite s) {
		if(appleCounter>0) {
			appleCounter -=1;
			s.getHealth();
			s.health += heal;
			check(s);
		}
		
	}
	/**
	 * Checks to make sure players health cannot go over the maximum player starting health
	 * @param s - The players health that the function is checking
	 */
	public void check(Sprite s) {
		s.getHealth();
		if(s.health>=500) {
			s.health = 500;
		}
		
		
	}

}
