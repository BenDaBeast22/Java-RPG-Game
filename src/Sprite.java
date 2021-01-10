import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

//This class creates the player which is who you are controlling and allows you to move around the map using the arrow keys. The player class can damage the enemy classes and can take damage from the enemy classes
public class Sprite extends PApplet {
	float x,y,w,h; //The position, width and height of the player
	int speedRight,speedLeft,speedUp,speedDown; //The speed that the player travels when those keys are pressed
	float direction; //Direction player goes when key is pressed
	float speed; //Speed of player
	int health; //Health of player
	int attack; //Max attack of player
	int score; //The amount of score your player has
	int sdamage=0; //The amount of damage the player deals
	int special; //The amount of damage players special attack deals 
	int encounterChance; //Determines the random enemy or item you encounter
	int amount; // Amoount of damage dealt by player
	public boolean right; //If right key was pressed
	public boolean left; //If left key was pressed
	public boolean up; //If up key was pressed
	public boolean down; //If down key was pressed
	public boolean move = true; //Whether the player moves(Simulates a turn in the game)
	public int dr,dl,du,dd; //The distance travelled in up,right,down,left directions
	float oldx = 0; //old x position 
	float oldy = 0; // old y position
	boolean go = false;
	
	private PApplet app;
	
	/**
	 * Creates player that you control to move using arrow keys
	 * @param p - PApplet Graphics
	 * @param spriteposx - Player xposition
	 * @param spriteposy - Player yposition
	 * @param spritewidth - Player width 
	 * @param spriteheight - Player height
	 * @param getAttack - Player max Attack
	 * @param getHealth - Player health
	 */
	Sprite(PApplet p,float spriteposx,float spriteposy,float spritewidth,float spriteheight,int getAttack,int getHealth){
	      this.app = p;
		  x = spriteposx;
	      y = spriteposy;
	      w = spritewidth;
	      h = spriteheight;
	      health = getHealth;
	      attack = getAttack;
	    
	      //speedX = 0;
	      //speedY = 0;
	      direction = 1;
	      speed = 1;
	  
	   }
	//Amount of damage dealt to player
	public void chp(int amountDamage) {
		int chp = amountDamage;
		health = health - chp;
		
	}
	/**
	 * score of Character
	 * @return score of Character
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Gives the character score (used after defeating enemies and using homework)
	 * @param addScore the amount of score you get when method is called
	 */
	public void addScore(int addScore) {
		score += addScore;	
	}
	/**
	 * Getter for the max attack of the player
	 * @return players Max attack
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * Random enemy or item encounter when you move and take a turn
	 */
	public void encounter() {
		encounterChance = (int)random(6);
		
		
	}
	/**
	 * Getter for player health
	 * @return players health
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * Player attacks enemy causing enemy to lose health
	 * @param e - Enemy loses health
	 */
	public void attack(Enemy e){
		 Random rand = new Random();
		 int sdamage = rand.nextInt(attack);
		 e.chp(sdamage);
	}
	/**
	 * Player attacks PhysicsTeacher causing PhysicsTeacher to lose health
	 * @param pt - PhysicsTeacher loses health
	 */
	public void attack(PhysicsTeacher pt){
		 Random rand = new Random();
		 int sdamage = rand.nextInt(attack);
		 pt.chp(sdamage);
	}
	/**
	 * Player attacks Teacher causing Teacher to lose health
	 * @param t - Teacher loses health
	 */
	public void attack(Teacher te){
		 Random rand = new Random();
		 int sdamage = rand.nextInt(attack);
		 te.chp(sdamage);
	}
	/**
	 * Player uses special attack on enemy dealing twice the damage
	 * @param e - enemy loses health
	 */
	public void specialAttack(Enemy e){
		 Random rand = new Random();
		 int special = (rand.nextInt(attack))*2;
		 e.chp(special);
	}
	/**
	 * Player uses special attack on PhysicsTeacher dealing twice the damage
	 * @param pt - PhysicsTeacher loses health
	 */
	public void specialAttack(PhysicsTeacher pt){
		 Random rand = new Random();
		 int special = (rand.nextInt(attack))*2;
		 pt.chp(special);
	}
	/**
	 * Player uses special attack on Teacher dealing twice the damage
	 * @param te - Teacher loses health
	 */
	public void specialAttack(Teacher te){
		 Random rand = new Random();
		 int special = (rand.nextInt(attack))*2;
		 te.chp(special);
	}
	/**
	 * Displays player image
	 */
	public void display(){
		app.image(app.loadImage("pokemon trainer.png"),x-4,y-6,w+7,h+10); 
	}
	/**
	 * Makes it so that player cannot escape the grid
	 */
	public void boundary(){
		if(x<=70){
			x=70;
		}
		if(x>=600){
			x=600;
		}
		if(y<=90){
			y=90;
		}
		if(y>=465){
			y=465;
		}
	}
	/**
	 * Saves the players old position so after battle he returns to position he was just at
	 */
	public void savePos(){
		oldx = x;
		oldy = y;
	}
	/**
	 * Player coordinates right before battle
	 */
	public void battlePos(){
		//previous sprite coordiantes before battle
		x = 320;
		y = 400;
		w = 80;
		h = 110;
	}
	//Resizes players width, height and resets players coordinates to original position after battle is over 
	public void reSize(){
		x = oldx;
		y = oldy;
		w = 30;
		h = 40;	   
	}
	//Moves player a certain distance when keys are pressed one tile on the grid
	public void update(){
		if(right==true&&move==true&&go==true){
			speedRight = 3;
			dr += speedRight;
			if(dr<=75) {
				x+=speedRight;
				move = true;      
			}	   
		}
		if(left==true&&move==true&&go==true){
			speedLeft = 3;
			dl += speedLeft;
			if(dl<=75) {
				x-=speedLeft;
				move =true;
				}
			}
		if(up==true&&move==true&&go == true){
			speedUp = 3;
			du += speedUp;
			if(du<=75) {
				y-=speedUp;
				move = true;
			}		   
		}
		if(down==true&&move==true&&go ==true){
			speedDown = 3;
			dd += speedDown;
			if(dd<=75) {
				y+=speedDown;
				move = true;	   
			}		   
		}
	}
				  
		  
}