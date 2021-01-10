import java.util.Random;
import processing.core.PApplet;

//Note: This class is supposed to be a sub class of the enemy class but I couldn't make it a sub class since you can only extend a class once in java and PApplet was already being extended
// This class is a different type of enemy that is much stronger than the normal enemy, he has more hp as well as increased attack;

public class PhysicsTeacher extends PApplet{
	float x,y,w,h; //The position, width and height of the enemy
	int attack,health; //The amount of attack and health of the PhysicsTeacher enemy 
	int edamage; //The amoount of damage that the physics teacher can deal
	private PApplet app;
	
	/**
	 * 
	 * @param p - PApplet graphics
	 * @param expos - PhysicsTeacher xposition
	 * @param eypos - PhysicsTeacher yposition
	 * @param ewidth - PhysicsTeacher width
	 * @param eheight - PhysicsTeacher height
	 * @param eattack - PhysicsTeacher max attack 
	 * @param ehealth - PhysicsTeacher health
	 */
	PhysicsTeacher(PApplet p,float expos, float eypos, float ewidth, float eheight,int eattack,int ehealth){
		this.app = p;
		x = expos;
		y = eypos;
		w = ewidth;
		h = eheight;
		attack = eattack;
		health = ehealth;
	}
	/**
	 * Displays the PhysicsTeacher enemy
	 */
	public void display(){
		app.image(app.loadImage("Physics Teacher.gif"),x-60,y-70,w+120,h+140);
		
	}
	/**
	 * The max amount of damage that the Physicsteacher can do to the player when he attacks him
	 * @param s
	 */
	public void attack(Sprite s){
		Random rand = new Random();
		int edamage = rand.nextInt(attack);
		s.chp(edamage);
	}
	/**
	 * The amount of damage that the player deals to the physics teacher when he attacks him
	 * @param amountDamage
	 */
	public void chp(int amountDamage) {
		int chp = amountDamage;
		health = health - chp;
	}
}
	