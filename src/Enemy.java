import java.util.*;
import processing.core.PApplet;

//This class creates enemies that the player can randomly encounter that can damage and kill the player.
//The player must defeat the enemies in order to move on through the game

public class Enemy extends PApplet{
	float x,y,w,h,speed,direction;
	int attack,health; //Enemy max attack and health
	int edamage;//Amount of damage that the enemy can deal to the player
	int counter = 0;
	private PApplet app;
	/**
	 * Constructs an enemy object
	 * @param p - PApplet Graphics 
	 * @param ewidth - The width of the enemy displayed
	 * @param eheight - The height of the enemy displayed
	 * @param eattack - The max amount of damage the enemy can deal
	 * @param ehealth - The amount of health that the enemy has
	 */
	Enemy(PApplet p, float xpos,float ypos,float ewidth, float eheight,int eattack,int ehealth){
		this.app = p;
		x = xpos;
		y = ypos;
		w = ewidth;
		h = eheight;
		direction = 1;
		attack = eattack;
		health = ehealth;
	}
	/**
	 * Displays the enemy with a picture
	 */
	public void display(){
			app.image(app.loadImage("Student Enemy.png"),x-17,y-30,w+40,h+60);
	}
	/**
	 * Getter for enemies health 
	 * @return
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * Amount of damage enemy takes from player when player performs an attack
	 * @param amountDamage - Amount of damage enemy takes from player
	 */
	public void chp(int amountDamage) {
		int chp = amountDamage;
		health = health - chp;
	}
	/**
	 * amount of damage that the enemy does to the player
	 * @param s - The player (Used to deduct his hp)
	 */
	public void attack(Sprite s){
		Random rand = new Random();
		int edamage = rand.nextInt(attack);
		s.chp(edamage);
	}
	
}
    
