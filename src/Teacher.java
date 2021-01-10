import java.util.Random;

//Note: The Teacher enemy was also supposed to be a subclass of enemy
// The Teacher Enemy is an enemy that is stronger than the normal enemy, but weaker than the Physics Teacher  
import processing.core.PApplet;
/**
 * 
 * @author Ben
 *
 */
public class Teacher extends PApplet{
	float x,y,w,h,speed,direction; //The position, width and height of the Teacher
	int attack,health; //The Teacher enemies max attack and health
	int edamage; //The amount of damage that the Teacher enemy can do to the player
	private PApplet app;
	/**
	 * Creates a teacher enemy
	 * @param p - PApplet graphics
	 * @param expos - xposition of the Teacher
	 * @param eypos - yposition of the Teacher
	 * @param ewidth - The width of the enemy
	 * @param eheight - The height of the enemy
	 * @param eattack - Teacher max damage
	 * @param ehealth - Teacher health
	 */
	Teacher(PApplet p,float expos, float eypos, float ewidth, float eheight,int eattack,int ehealth){
		this.app = p;
		x = expos;
		y = eypos;
		w = ewidth;
		h = eheight;
		direction = 1;
		attack = eattack;
		health = ehealth;
	}
	/**
	 * Displays the Teacher enemy
	 */
	public void display(){
			app.image(app.loadImage("Professor.png"),x-17,y+35,w+30,h+30);
	}
	/**
	 * The amount of damage that the Teacher loses when the player attacks him 
	 * @param amountDamage - amount of damage player does 
	 */
	public void chp(int amountDamage) {
		int chp = amountDamage;
		health = health - chp;
	}
	/**
	 * The amount of damage that the Teacher does to the player
	 * @param s - The player that loses health when attacked by the teacher
	 */
	public void attack(Sprite s){
		Random rand = new Random();
		int edamage = rand.nextInt(attack);
		s.chp(edamage);
	}
		
}
  
	
