import processing.core.PApplet;

//An object that is randomly dropped that gives the player score when used


public class Homework extends PApplet{
	int homeworkCounter; //amount of homework objects player has collected
	
	/**
	 * Creates a homework object
	 */
	public Homework() {
		homeworkCounter = 0;
		
	}
	/**
	 * Adds a homework object to a counter to be used
	 */
	public void add() { 
		homeworkCounter +=1;
	}
	/**
	 * Gives player 200 score for every homework item that you posses
	 * @param s - The player that gains the score when hw is used
	 */
	public void use(Sprite s) {
		if(homeworkCounter>0) {
			homeworkCounter -=1;
			s.addScore(200);
		}
	}		
	
}
