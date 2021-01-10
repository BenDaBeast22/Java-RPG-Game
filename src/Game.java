import processing.core.*;

//Main Class

/* Game brief explanation: How my program works is that you control a player with the arrow keys and this causes you to move on tile
 * in that direction on the map. When you move once that counts as a turn and there is a random chance that you will either encounter
 * an enemy or collect an item. To win the game you must survive and defeat all enemies you battle, while collecting the three white 
 * tests on the map. Once you have collected these three tests the exam(golden test) will become visible and collectible so that once
 * you collect it you win the game
 * 
 *  Problems:  
 *  I couldn't figure out how to create sub classes on eclipse because for all of my classes PAPplet is already being extended and I couldn't figure
 *  out how to extend multiple classes in one class. Also sometimes I noticed that player take damage when the mouse is hovered sometimes.
 
 */

public class Game extends PApplet{
	PImage student;
	PImage enemy;
	PImage exam;
	PImage test;
	int gamestate = 0; //Can be used to set game screen
	boolean click;
	boolean keyClick = false;
	boolean pressed = false;
	int chargeCounter = 0;
	int numDisappear = 1;
	int scoreCounter = 0;
	int start;
	int m;
	boolean move = false;
	boolean movingKeyPressed = false;
	boolean endGame = false;
	boolean alive = true;
	
	//Calling Methods
	Sprite s;
	Sprite s2;
	Test t;
	Test t2;
	Test t3;
	Enemy e0;
	Enemy e;
	Enemy e2;
	Enemy e3;
	Enemy e4;
	PhysicsTeacher pt;
	Teacher te;
	Exam ex;
	Apple a;
	Homework h;
	Pencil p;
	
	
	public static void main(String[]args) {
		PApplet.main("Game");
	}
	

	public void settings() {
		size(700,650);
		
	}
	
	public void setup() {
		background(0);
		smooth();
		cursor(HAND);
		
		
		//Sprite Initializations
		s = new Sprite(this,70,470,30,40,50,500);
		//s2 = new Sprite(this,310,500,60,80,20,500);
		
		//Enemy Initializations
		e0 = new Enemy(this,308,110,120,180,35,150);//This enemy was only used for display battle purposes 120,170
		e = new Enemy(this,305,170,20,30,35,150);//56,385
		

		//test Initializations
		t = new Test(this,525,325,20,25);
		t2 = new Test(this,152,325,20,25);
		t3 = new Test(this,70,105,20,25);
		
		//Exam initialization
		ex = new Exam(this,590,100,20,25);
		
		//Physics Teacher initializiaton
		pt = new PhysicsTeacher(this,305,100,120,170,45,250);//
		
		//Teacher initialization
		te = new Teacher(this,305,100,120,170,40,200);
		
		//Apple initialization
		a = new Apple();
		
		//Homework Initialization
		h = new Homework();
		
		//Pencil Initialization
		p = new Pencil();
	}
	//Different gamestates that are changed when an event occurs
	public void draw(){
		if(gamestate == -1) {
			gameover();
		}
		  
		else if(gamestate == 0){
			menu();
		}
  
		else if(gamestate == 1){
			gameStart();
		}
		
		else if(gamestate == 2) {
			instructions();
		}
		else if(gamestate == 3) {
			winGame();
		}
		else if(gamestate == 10) {
			battleScreen();
			
		}
		else if(gamestate == 11) {
			battleScreen2();
		}
		else if(gamestate == 12) {
			battleScreen3();
		}
	} 
	
	public void menu(){
		  //Menu Background and titles
		  background(34,139,34);
		  fill(255);
		  textSize(55);
		  text("Survive School",170,140);
		  textSize(35);
		  fill(255);
		  text("Created by B.C Productions",width/2-225,230);  
		  
		  //Play Button
		  stroke(255);
		  fill(160,82,45);
		  rect(295,285,90,50);
		  stroke(0);
		  fill(255);
		  textSize(30);
		  text("Play",310,320);
		  
		  if(click == true&&((mouseX>= 295) && (mouseX<=385)&&(mouseY>=285)&&(mouseY<=335))){
		        click = false;
			  	gamestate = 1;
		  }
		  if((mouseX>= 295) && (mouseX<=385)&&(mouseY>=285)&&(mouseY<=335)){
		     stroke(255);
		     fill(139,69,19);
		     rect(295,285,90,50);
		     fill(255);
		     text("Play",310,320);
		  }
		  
		  //Instructions Button
		  fill(160,82,45);
		  stroke(255);
		  rect(245,375,190,50);
		  stroke(0);
		  fill(255);
		  textSize(30);
		  text("Instructions",255,410);
		  
		  if(click == true&&((mouseX>= 245) && (mouseX<=435)&&(mouseY>=375)&&(mouseY<=425))){
		      click = false;
			  gamestate = 2;
		  }
		  if((mouseX>= 245) && (mouseX<=435)&&(mouseY>=375)&&(mouseY<=425)){
			  stroke(255);
		      fill(139,69,19);
		      rect(245,375,190,50);
		      fill(255);
		      textSize(30);
		      text("Instructions",255,410);
		    }
		}
		//Game Class
		public void gameStart(){
			//Background Graphics and Text
			background(135,206,250);
			fill(205,133,63);
			rect(50,80,600,450);
			fill(250);
			textSize(25);
			text("Health: "+s.health,515,50);
			text("Score:"+s.getScore(),170,50);
			text("Damage: "+s.getAttack(),320,50);
			
			//Menu Button
			stroke(255);
			fill(135,206,250);
			rect(50,20,80,40);
			fill(255);
			text("Menu",57,50);
			stroke(0);
		
			//mouse clicked
			if(click == true &&((mouseX >=50) && (mouseX<= 130)&&(mouseY >= 20)&&(mouseY <= 60))) {
				click = false;
				gamestate = 0;
				System.out.println(gamestate);
			}
			//mouse hovered
			if((mouseX >= 50) && (mouseX <= 130)&&(mouseY >= 20)&&(mouseY <= 60)){
				stroke(255);
				fill(255);
				rect(50,20,80,40);
				fill(135,206,250);
				text("Menu",57,50);
				stroke(0);
			}
			
			//Grid Horizantal Lines
			fill(0);
			line(125,80,125,530);
			line(200,80,200,530);
			line(275,80,275,530);
			line(350,80,350,530);
			line(425,80,425,530);
			line(500,80,500,530);
			line(575,80,575,530);
			
			//Grid Vertical Lines
			line(50,150,650,150);
			line(50,225,650,225);
			line(50,300,650,300);
			line(50,375,650,375);
			line(50,450,650,450);
			
			//Apple Button - Press in order to use an apple
			fill(0,128,255);
			rect(50,550,165,50);
			fill(255);
			textSize(20);
			text("Apple x "+a.appleCounter,75,580);
			
			//mouse clicked
			if(click==true&&((mouseX>= 50) && (mouseX<=215)&&(mouseY>=550)&&(mouseY<=600))){
				click = false;
				a.use(s);
			}
			//mouse hovered
			if((mouseX >= 50) && (mouseX <= 215)&&(mouseY >= 550)&&(mouseY <= 600)){
				fill(0,204,204);
				rect(50,550,165,50);
				fill(255);
				textSize(20);
				text("Apple x "+a.appleCounter,75,580);
			}
			
			//Homework Button
			fill(0,128,255);
			rect(250,550,195,50);
			fill(255);
			textSize(20);
			text("Homework x "+h.homeworkCounter,275,580);
			//mouse clicked
			if(click==true&&((mouseX>= 250) && (mouseX<=445)&&(mouseY>=550)&&(mouseY<=600))){
				click = false;
				h.use(s);
			}
			//mouse hovered
			if((mouseX >= 250) && (mouseX <= 445)&&(mouseY >= 550)&&(mouseY <= 600)){
				fill(0,204,204);
				rect(250,550,195,50);
				fill(255);
				textSize(20);
				text("Homework x "+h.homeworkCounter,275,580);
			}
			
			//Pencil Button
			fill(0,128,255);
			rect(475,550,175,50);
			fill(255);
			textSize(20);
			text("Pencil x "+p.pencilCounter,500,580);
			//mouse clicked
			if(click==true&&((mouseX>= 475) && (mouseX<=650)&&(mouseY>=550)&&(mouseY<=600))){
				click = false;
				p.use(s);
			}
			//mouse hovered
			if((mouseX >= 475) && (mouseX <= 650)&&(mouseY >= 550)&&(mouseY <= 600)){
				fill(0,204,204);
				rect(475,550,175,50);
				fill(255);
				textSize(20);
				text("Pencil x "+p.pencilCounter,500,580);
			}
			
			//player methods
			s.display();
			s.update();
			s.boundary();
		
			//test methods
			t.display();
			t2.display();
			t3.display();
		  
			//Exam methods
			ex.display();
			
			//Turn Sequence
			if(move==true) {
				e.counter = 0;
				s.encounter();
				s.savePos();
				if(s.encounterChance == 0) {
						gamestate = 10;
					  
					  
				}
				else if(s.encounterChance == 1) {
					gamestate = 11;
				}
				else if(s.encounterChance == 2) {
					gamestate = 12;
					
				}
				else if(s.encounterChance == 3) {
					a.add();
						
				}
				else if(s.encounterChance == 4) {
					h.add();
				}
				else if(s.encounterChance == 5) {
					p.add();
				}
				move = false;
					
				}
				 
				
			else if(move==false && alive == true) {
				gamestate = 1;
				e.health = 150;
			}
			else if(move == false &&alive == false){
				gamestate = -1;
			}
			
			
			//test collisions
			
			if(t.disappear==false){
				if(collision(s,t)){
					t.disappear = true;
					ex.testCount();
				}
			}
			if(t2.disappear==false){
				if(collision(s,t2)){
					t2.disappear = true;
					ex.testCount();
				}
			}
			if(t3.disappear==false){
				if(collision(s,t3)){
					t3.disappear = true;
					ex.testCount();
				}
			}
			if(ex.disappear==false){
				if(collision(s,ex)){
					ex.Collectable();
					if(ex.collectable == true) {
						//ex.levelTransition();
						//ex.TransitionMove();
						ex.disappear = true;
						gamestate = 3;
					}
				}
				
			}
		}
		//Battle against Enemy
		public void battleScreen(){
			  background(135,206,250);
			  s.battlePos();
			  s.display();
			  e0.display();
			  
			  //Enemy HP
			  fill(255);
			  textSize(50);
			  text("Battle!",290,50);
			  textSize(25);
			  text("HP:"+e.health,322,120);
			  //Player HP
			  text("HP:"+s.health,322,385);
			  //Special Counter
			  fill(255);
			  textSize(25);
			  text("Charge:"+chargeCounter,310,550);
			  
			  //atack button
			  fill(32,178,170);
			  rect(460,415,100,40);
			  fill(255);
			  textSize(23);
			  text("Attack",475,444);
			  
			  //VS(States Enemy Name)
			  textSize(30);
			  text("Student",110,230);
			  stroke(255);
			  line(110,250,225,250);
			  line(110,390,225,390);
			  textSize(45);
			  stroke(0);
			  text("VS",140,340);
			  textSize(30);
			  text("Student",110,435);
			  
			  //Special Attack button
			  fill(32,178,170);
			  rect(460,470,100,40);
			  fill(255);
			  textSize(23);
			  text("Super",477,497);
			  
			  
			  
			  //Turned based Battle
			  if(s.health>0){
				  //normal attack
			      if(click == true && ((mouseX>= 460) && (mouseX<=560)&&(mouseY>=415)&&(mouseY<=455))){
			        click = false;
			        s.attack(e);
			        chargeCounter+=1;
			        if(e.health>0){
			          e.attack(s);
			        }
			        if(e.health<=0){
		
			        	s.addScore(100);
						chargeCounter = 0;
						s.reSize();
						gamestate =1;
						move = false;
			        	
			        }
			      }
			      //special attack
			      else if(click == true&&((mouseX>= 460) && (mouseX<=560)&&(mouseY>=470)&&(mouseY<=510))){
			        click = false;
			        if(chargeCounter>=3){
			          s.specialAttack(e);
			          chargeCounter-=3;
			        }
			        if(e.health>0){
			          e.attack(s);
			        }
			        if(e.health<=0){
			        	s.addScore(100);
			        	chargeCounter = 0;
			        	s.reSize();
			        	gamestate = 1;
			        	alive = true;
			        	move = false;

			        	
			          
			        }
			        }

			        
			   }
			   else{
				 alive = false;
				 move = false;
			     gamestate = -1;
			    
			   }
			  //attack button hover     
			  if((mouseX>= 460) && (mouseX<=560)&&(mouseY>=415)&&(mouseY<=455)){
			    fill(30,144,255);
			    rect(460,415,100,40);
			    fill(255);
			    text("Attack",475,444);
			  }
			  if((mouseX>= 460) && (mouseX<=560)&&(mouseY>=470)&&(mouseY<=510)){
			    fill(30,144,255);
			    rect(460,470,100,40);
				fill(255);
				textSize(23);
				text("Super",477,497);
			  }
		}
		//Battle Against Teacher
		public void battleScreen2() {
			 background(135,206,250);
			  s.battlePos();
			  s.display();
			  te.display();
			  
			  //Enemy HP
			  fill(255);
			  textSize(50);
			  text("Battle!",290,50);
			  textSize(25);
			  text("HP:"+te.health,322,120);
			  
			  //Player HP
			  text("HP:"+s.health,322,385);
			  
			  //Special Counter
			  fill(255);
			  textSize(25);
			  text("Charge:"+chargeCounter,310,550);
			  
			  //atack button
			  fill(32,178,170);
			  rect(460,415,100,40);
			  fill(255);
			  textSize(23);
			  text("Attack",475,444);
			  
			  //VS(States Enemy Name)
			  textSize(30);
			  text("Teacher",110,230);
			  stroke(255);
			  line(110,250,225,250);
			  line(110,390,225,390);
			  textSize(45);
			  stroke(0);
			  text("VS",140,340);
			  textSize(30);
			  text("Student",110,435);
			  
			//Special Attack button
			  fill(32,178,170);
			  rect(460,470,100,40);
			  fill(255);
			  textSize(23);
			  text("Super",477,497);
			  
			  
			  
			  
			  //Turned based Battle
			  if(s.health>0){
				  //normal attack
			      if(click == true&&((mouseX>= 460) && (mouseX<=560)&&(mouseY>=415)&&(mouseY<=455))){
			        click = false;
			        s.attack(te);
			        chargeCounter+=1;
			        if(te.health>0){
			          te.attack(s);
			        }
			        if(te.health<=0){
			          gamestate = 1;
			          s.addScore(100);
			          chargeCounter = 0;
			          s.reSize();
			          te.health=200;
			          alive = true;
			          move = false;
			        }
			      }
			      //special attack
			      else if(click == true&&((mouseX>= 460) && (mouseX<=560)&&(mouseY>=470)&&(mouseY<=510))){
			        click = false;
			        if(chargeCounter>=3){
			          s.specialAttack(te);
			          chargeCounter-=3;
			        }
			        if(te.health>0){
			          te.attack(s);
			        }
			        if(te.health<=0){
			          gamestate = 1;
			          s.addScore(100);
			          chargeCounter = 0;
			          s.reSize();
			          te.health=150;
			          alive = true;
			          move = false;
			          
			        }
			        }

			        
			   }
			   else{
				   alive = false;
				   gamestate = -1;
			    
			   }
			  //attack buttons hover     
			  if((mouseX>= 460) && (mouseX<=560)&&(mouseY>=415)&&(mouseY<=455)){
			    fill(30,144,255);
			    rect(460,415,100,40);
			    fill(255);
			    text("Attack",475,444);
			  }
			  if((mouseX>= 460) && (mouseX<=560)&&(mouseY>=470)&&(mouseY<=510)){
			    fill(30,144,255);
			    rect(460,470,100,40);
				fill(255);
				textSize(23);
				text("Super",477,497); 
			  }
		}
		//Battle Against PhysicsTeacher
		public void battleScreen3(){
			  background(135,206,250);
			  s.battlePos();
			  s.display();
			  pt.display();
			  
			  //Enemy HP
			  fill(255);
			  textSize(50);
			  text("Battle!",295,65);
			  textSize(25);
			  text("HP:"+pt.health,322,120);
			  //Player HP
			  text("HP:"+s.health,322,385);
			  //Special Counter
			  fill(255);
			  textSize(25);
			  text("Charge:"+chargeCounter,310,560);
			  textSize(30);
			  
			  //VS Text(States the name of the Enemy)
			  text("Physics Teacher",50,230);
			  stroke(255);
			  line(50,250,275,250);
			  line(110,390,225,390);
			  stroke(0);
			  textSize(45);
			  text("VS",140,340);
			  textSize(30);
			  text("Student",110,435);
			  
			  
			  //atack button
			  fill(32,178,170);
			  rect(460,415,100,40);
			  fill(255);
			  textSize(23);
			  text("Attack",475,444);
			  
			  //Special Attack button
			  fill(32,178,170);
			  rect(460,470,100,40);
			  fill(255);
			  textSize(23);
			  text("Super",477,497);
			  
			  //Turned based Battle
			  if(s.health>0){
				  //normal attack
			      if(click == true && ((mouseX>= 460) && (mouseX<=560)&&(mouseY>=415)&&(mouseY<=445))){
			        click = false;
			        s.attack(pt);
			        chargeCounter+=1;
			        if(pt.health>0){
			          pt.attack(s);
			        }
			        if(pt.health<=0){
		
			        	s.addScore(100);
						chargeCounter = 0;
						s.reSize();
						gamestate =1;
						pt.health = 250;
						alive = true;
						move = false;
			        	
			        }
			      }
			      //special attack
			      else if(click == true&&((mouseX>= 460) && (mouseX<=560)&&(mouseY>=470)&&(mouseY<=510))){
			        click = false;
			        if(chargeCounter>=3){
			          s.specialAttack(pt);
			          chargeCounter-=3;
			        }
			        if(pt.health>0){
			          pt.attack(s);
			        }
			        if(pt.health<=0){
			        	s.addScore(100);
			        	chargeCounter = 0;
			        	s.reSize();
			        	gamestate = 1;
			        	pt.health = 250;
			        	alive = true;
			        	move = false;

			        	
			          
			        }
			        }

			        
			   }
			   else{
				 alive = false;
				 move = false;
			     gamestate = -1;
			    
			   }
			  //attack button hover     
			  if((mouseX>= 460) && (mouseX<=560)&&(mouseY>=415)&&(mouseY<=455)){
			    fill(30,144,255);
			    rect(460,415,100,40);
			    fill(255);
			    text("Attack",475,444);
			  }
			  //special attack button hover
			  if((mouseX>= 460) && (mouseX<=560)&&(mouseY>=470)&&(mouseY<=510)){
			    fill(30,144,255);
			    rect(460,470,100,40);
				fill(255);
				textSize(23);
				text("Super",477,497);
			  }
			}
		
	//Screen you go to if player hp is <=0
	public void gameover() {
		background(0);
		textSize(50);
		fill(255);
		text("Game Over!",210,300);
		textSize(30);
		rect(300,380,90,45);
		fill(0);
		text("Menu",305,410);
		
		if(click==true&&((mouseX>= 300) && (mouseX<=390)&&(mouseY>=380)&&(mouseY<=425))){
			//resetting all variables
			click = false;
			gamestate = 0;
			s.health = 500;
			s.reSize();
			s.x = 70;
			s.y = 465;
			pt.health = 250;
			e.health = 150;
			t.disappear = false;
			t2.disappear = false;
			t3.disappear = false;
			te.health = 200;
			ex.testCounter = 0;
			a.appleCounter = 0;
			h.homeworkCounter = 0;
			p.pencilCounter = 0;
			chargeCounter = 0;
			s.score = 0;
			s.attack = 50;
			alive = true;
		}

		if((mouseX >= 300) && (mouseX <= 390)&&(mouseY >= 380)&&(mouseY <= 425)){
			fill(0);
			rect(300,380,90,45);
			fill(255);
			text("Menu",305,410);
		}
	}
	//How to play
	public void instructions() {
		background(135,206,250);
		textSize(40);
		fill(255);
		text("Instructions",240,50);
		textSize(18);
		text("You are a highschool student. Your goal is to collect all 3 tests on the",30,100);
		text("map and reach the golden exam in order to win the game! To move your",30,150);
		text("player use the arrow keys. Everytime you move you will either battle an",30,200);
		text("enemy or collect an item. To use an item press on one of the 3 item",30,250);
		text("buttons below the map. Homework gives you score, apples recover health",30,300);
		text("and pencils increase your max attack. To make thigs more difficult every",30,350);
		text("turn you move you have a chance of battling an enemy. To use a normal",30,400); 
		text("attack press the attack button next to your player. To use your special",30,450); 
		text("attack you have to have at least 3 charges and then press the special",30,500);
		text("attack button right below the attack button. Thats it, now can you",30,550);
		textSize(25);
		text("Survive School!!!",240,600);
		
		fill(0,204,204);
		rect(50,580,100,40);
		textSize(20);
		fill(255);
		text("Menu",75,607);
		
		if(click==true&&((mouseX>= 50) && (mouseX<=150)&&(mouseY>=580)&&(mouseY<=620))){
			click = false;
			gamestate = 0;
		}
		if((mouseX >= 50) && (mouseX <= 150)&&(mouseY >= 580)&&(mouseY <= 620)){
			fill(0,230,197);
			rect(50,580,100,40);
			textSize(20);
			fill(255);
			text("Menu",75,607);
		}
		
		
	}
	//Screen if you win
	public void winGame() {
		fill(255);
		background(0);
		textSize(60);
		text("You Win!!!",200,300);
		textSize(40);
		text("Score "+s.getScore(),255,400);
		
		//Menu Button
		fill(255);
		//rect(300,500,80,40);
		fill(0);
		textSize(18);
		fill(255);
		text("Menu",315,524);
		
		if(click==true&&((mouseX>= 300) && (mouseX<=380)&&(mouseY>=500)&&(mouseY<=540))){
			//resetting all variables
			click = false;
			gamestate = 0;
			s.health = 500;
			s.reSize();
			s.x = 70;
			s.y = 465;
			pt.health = 250;
			e.health = 150;
			t.disappear = false;
			t2.disappear = false;
			t3.disappear = false;
			te.health = 200;
			ex.testCounter = 0;
			a.appleCounter = 0;
			h.homeworkCounter = 0;
			p.pencilCounter = 0;
			s.score = 0;
			s.attack = 50;
			chargeCounter = 0;
			alive = true;
		}
		if((mouseX >= 300) && (mouseX <= 380)&&(mouseY >= 500)&&(mouseY <= 540)){
			fill(180);
			textSize(18);
			text("Menu",315,524);
			fill(255);
		}
		
		
	}
	
		//collision detection between player and test
		boolean collision(Sprite c1, Test c2){
		  //x distance apart 
		  float distancex = (c1.x + c1.w/2) - (c2.x + c2.w/2);
		  //y distance apart 
		  float distancey = (c1.y + c1.h/2) - (c2.y + c2.h/2);
		  //combined half widths
		  float halfwidth = c1.w/2 +c2.w/2;
		  //combined half heights
		  float halfheight = c1.h/2 + c2.h/2;
		  //check x collisions
		  if(abs(distancex)<halfwidth){
		    if(abs(distancey) < halfheight){
		      return true;
		    }
		  }
		  return false;
		}
		//collision detection between player and exam
		boolean collision(Sprite c1, Exam c2){
		  //x distance apart 
		  float distancex = (c1.x + c1.w/2) - (c2.x + c2.w/2);
		  //y distance apart 
		  float distancey = (c1.y + c1.h/2) - (c2.y + c2.h/2);
		  //combined half widths
		  float halfwidth = c1.w/2 +c2.w/2;
		  //combined half heights
		  float halfheight = c1.h/2 + c2.h/2;
		  //check x collisions
		  if(abs(distancex)<halfwidth){
		    if(abs(distancey) < halfheight){
		      return true;
		    }
		  }
		  return false;
		}
		
		public void mouseClicked(){
			  if(true){
			    click = true; 
			  }
			  
			  
		}
	
		public void keyReleased()
		{
			if (key == CODED)
			{
				if (keyCode == LEFT)
				{
					s.go = true;
					s.left = true;
					move = true;
				}
				if (keyCode == RIGHT)
				{
					s.go = true;
					s.right = true;
					move = true;
				}
				if (keyCode == UP)
				{
					s.go = true;
					s.up = true;
					move = true;
				}
				if (keyCode == DOWN)
				{
					s.go =true;
					s.down = true;
					move = true;
				}
			}
		}
	
		public void keyPressed()
		{	
			if (key == CODED)
			{
				if (keyCode == LEFT)
				{	s.go=false;
					s.dl = 0;
					s.speedLeft=0;
				}
				if (keyCode == RIGHT)
				{	s.go=false;
					s.dr = 0;
					s.speedRight=0;
				}

				if(keyCode == UP){
					s.go=false;
					s.du = 0;
					s.speedUp=0;
				}
					
				if(keyCode == DOWN){
					s.go=false;
					s.dd = 0;
					s.speedDown=0;
				}
			}
		}
	
	}